package com.example.taxserviceservlet.dao;

import com.example.taxserviceservlet.entity.*;
import com.example.taxserviceservlet.web.dto.SortField;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ReportsDao implements Crud<Report, Long> {

    @Override
    public Optional<Report> findById(Long reportId) {

        String findByIdQuery = "SELECT * FROM report WHERE id = ?";

        Report report = null;
        Connection connection = DaoConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(findByIdQuery)) {

            preparedStatement.setLong(1, reportId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                report = Report.builder()
                        .id(resultSet.getLong("id"))
                        .income(resultSet.getInt("income"))
                        .taxRate(resultSet.getInt("tax_rate"))
                        .taxPeriod(TaxPeriod.valueOf(resultSet.getString("tax_period")))
                        .status(Status.valueOf(resultSet.getString("status")))
                        .year(resultSet.getInt("year"))
                        .comment(resultSet.getString("comment"))
                        .reportDate(resultSet.getDate("report_date"))
                        .userId(resultSet.getLong("user_id"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.ofNullable(report);
    }

    @Override
    public List<Report> findAll() {
        return null;
    }

    @Override
    public User save(Report o) {
        return null;
    }

    @Override
    public User update(Report o) {
        return null;
    }

    @Override
    public boolean delete(Report o) {
        return false;
    }

    public List<Report> findByParamWithUser(Long id, Date reportDate, TaxPeriod period,
                                    Status status, SortField sortField, Integer pageNumber) throws SQLException {

        // ToDo: refactor filtering by period and status

        String sortBy = sortField == null ? "r.id " : sortField.fieldInTable + " " + sortField.direction;

        String query = "select rr.*, u.first_name, u.last_name, u.ipn " +
                "FROM ( select r.* from report r " +
                "WHERE r.user_id = (IF(? IS NULL, r.user_id, ?))" +
                "AND r.report_date = (IF(? IS NULL, r.report_date, ?))" +
                "AND r.tax_period = (IF(? = 'null', r.tax_period, ?))" +
                "AND r.status = (IF(? = 'null', r.status, ?))" +
                ") rr left join user u on rr.user_id = u.id order by " + sortBy;

//        String query = "select * from report r " +
//                "WHERE r.user_id = (CASE WHEN ? IS NULL THEN r.user_id ELSE ? END)" +
//                " AND r.report_date = (CASE WHEN ? IS NULL THEN r.report_date ELSE ? END)" +
//                " AND r.tax_period = (CASE WHEN ? = 'null' THEN r.tax_period ELSE ? END)" +
//                " AND r.status = (CASE WHEN ? = 'null' THEN r.status ELSE ? END)" +
//                " ORDER BY " + sortBy + " LIMIT 5 OFFSET ?";

        List<Report> reports = new ArrayList<>();

        Connection connection = DaoConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setObject(1, id);
            preparedStatement.setObject(2, id);
            preparedStatement.setDate(3, reportDate);
            preparedStatement.setDate(4, reportDate);
            preparedStatement.setString(5, String.valueOf(period));
            preparedStatement.setString(6, String.valueOf(period));
            preparedStatement.setString(7, String.valueOf(status));
            preparedStatement.setString(8, String.valueOf(status));
//            preparedStatement.setInt(9, (pageNumber - 1) * 5);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Report report = new Report.Builder()
                        .id(resultSet.getLong("id"))
                        .taxPeriod(TaxPeriod.valueOf(resultSet.getString("tax_period")))
                        .year(resultSet.getInt("year"))
                        .income(resultSet.getInt("income"))
                        .taxRate(resultSet.getInt("tax_rate"))
                        .reportDate(resultSet.getDate("report_date"))
                        .status(Status.valueOf(resultSet.getString("status")))
                        .comment(resultSet.getString("comment"))
                        .userId(resultSet.getLong("user_id"))
                        .user(new User.Builder()
                                .userId(resultSet.getLong("user_id"))
                                .firstName(resultSet.getString("first_name"))
                                .lastName(resultSet.getString("last_name"))
                                .ipn(resultSet.getString("ipn"))
                                .build())
                        .build();
                reports.add(report);
            }
        }
        return reports;
    }

    public Map<String, Long> getStatisticDataReportsCount() {

        String statisticReportsCountQuery = " SELECT COUNT(*) AS count, " +
                " SUM(IF(r.status = 'PROCESSING', 1, 0)) AS processing_count," +
                " SUM(IF(r.status = 'APPROVED', 1, 0)) AS approved_count," +
                " SUM(IF(r.status = 'DISAPPROVED', 1, 0)) AS disapproved_count" +
                " FROM report AS r";

        Connection connection = DaoConnection.getConnection();

        Map<String, Long> data = new TreeMap<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(statisticReportsCountQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                data.put("count", resultSet.getLong("count"));
                data.put("processing_count", resultSet.getLong("processing_count"));
                data.put("approved_count", resultSet.getLong("approved_count"));
                data.put("disapproved_count", resultSet.getLong("disapproved_count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Map<Integer, Long> getStatisticDataReportsPerYearCount() {

        String statisticReportsCountQuery =
                "SELECT year, COUNT(*) AS count FROM report AS r GROUP BY r.year ORDER BY year";

        Connection connection = DaoConnection.getConnection();

        Map<Integer, Long> data = new TreeMap<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(statisticReportsCountQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                data.put(resultSet.getInt("year"), resultSet.getLong("count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
