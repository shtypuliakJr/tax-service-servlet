package com.example.taxserviceservlet.dao;

import com.example.taxserviceservlet.entity.Report;
import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;
import com.example.taxserviceservlet.entity.User;
import com.example.taxserviceservlet.web.dto.ReportDTO;
import com.example.taxserviceservlet.web.dto.SortField;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReportsDao implements Crud<Report, Long> {

    @Override
    public Optional<Report> findById(Long aLong) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Report> findAll() throws SQLException {
        return null;
    }

    @Override
    public User save(Report o) throws SQLException {
        return null;
    }

    @Override
    public User update(Report o) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Report o) throws SQLException {
        return false;
    }

    public List<Report> findByParam(Long id, Date reportDate, TaxPeriod period,
                                    Status status, SortField sortField) throws SQLException {

        String query = "select rr.*, u.first_name, u.last_name, u.ipn " +
                "FROM ( select r.* from report r " +
                "WHERE r.user_id = (CASE WHEN ? IS NULL THEN r.user_id ELSE ? END)" +
                "AND r.report_date = (CASE WHEN ? IS NULL THEN r.report_date ELSE ? END)" +
                "AND r.tax_period = (CASE WHEN ? = 'null' THEN r.tax_period ELSE ? END)" +
                "AND r.status = (CASE WHEN ? = 'null' THEN r.status ELSE ? END)" +
                ") rr left join user u on rr.user_id = u.id";

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

            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(preparedStatement);
            System.out.println(query);
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
//                System.out.println("REPORT in DAO\n" + report);
                reports.add(report);
            }
            System.out.println(reports);
//            reports.forEach(System.out::println);
        }
        return reports;
    }

    public <T> String filterField(T param, String fieldName) {
        System.out.println(fieldName + " " + param);
        return Optional.ofNullable(param).map((p) -> " AND r." + fieldName + " = '" + param + "'")
                .orElse("");

    }
}
