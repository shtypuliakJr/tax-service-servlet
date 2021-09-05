package com.example.taxserviceservlet.dao.impl;

import com.example.taxserviceservlet.dao.DaoConnection;
import com.example.taxserviceservlet.dao.ReportDao;
import com.example.taxserviceservlet.dao.mapper.ObjectMapper;
import com.example.taxserviceservlet.dao.mapper.ReportMapper;
import com.example.taxserviceservlet.dao.mapper.UserMapper;
import com.example.taxserviceservlet.entity.Report;
import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;
import com.example.taxserviceservlet.web.dto.SortField;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ReportDaoImpl implements ReportDao {

    ObjectMapper<Report> mapper = new ReportMapper();

    @Override
    public List<Report> findAll() {
        return null;
    }

    @Override
    public Report save(Report o) {
        return null;
    }

    @Override
    public Report update(Report report) {

        String updateReportQuery = "UPDATE report r SET r.comment = ?, r.status = ? WHERE r.id = ?";

        Connection connection = DaoConnection.getConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(updateReportQuery)) {

            preparedStatement.setString(1, report.getComment());
            preparedStatement.setString(2, String.valueOf(report.getStatus()));
            preparedStatement.setLong(3, report.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return report;
    }

    @Override
    public boolean delete(Long o) {
        return false;
    }

    @Override
    public Optional<Report> findById(Long reportId) {

        String findByIdQuery = "SELECT * FROM report WHERE id = ?";

        Report report = null;
        Connection connection = DaoConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(findByIdQuery)) {

            preparedStatement.setLong(1, reportId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                report = mapper.extractFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.ofNullable(report);
    }

    public List<Report> findByParamWithUser(Long id, Date reportDate, TaxPeriod period,
                                            Status status, SortField sortField) {

        String sortBy = sortField == null ? "r.id " : sortField.fieldInTable + " " + sortField.direction;

        String query = "select rr.*, u.first_name, u.last_name, u.ipn " +
                "FROM ( select r.* from report r " +
                "WHERE r.user_id = (IF(? IS NULL, r.user_id, ?))" +
                "AND r.report_date = (IF(? IS NULL, r.report_date, ?))" +
                "AND r.tax_period = (IF(? = 'null', r.tax_period, ?))" +
                "AND r.status = (IF(? = 'null', r.status, ?))" +
                ") rr left join user u on rr.user_id = u.id order by " + sortBy;

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

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Report report = mapper.extractFromResultSet(resultSet);
                report.setUser(UserMapper.extractUserFromResultSetForReport(resultSet));
                reports.add(report);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
