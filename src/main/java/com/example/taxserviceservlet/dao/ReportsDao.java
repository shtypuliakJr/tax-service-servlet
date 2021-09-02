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
import java.util.Date;
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

        String query = "SELECT * FROM report r " +
                "WHERE r.user_id = (CASE WHEN ? IS NULL THEN r.user_id ELSE ? END)";
        System.out.println("in ");
//
//        query += (filterField(id, "r.user_id"));
//        query += (filterField(reportDate, "r.report_date"));
//        query += (filterField(period, "r.tax_period"));
//        query += (filterField(status, "r.status"));

        System.out.println("Query = " + query);
        List<Report> reports = new ArrayList<>();
        Connection connection = DaoConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            if (id == null) {
                System.out.println("null");
                preparedStatement.setNull(1, Types.NULL);
                preparedStatement.setNull(2, Types.NULL);
            } else {
                System.out.println("not null + "  + id);
                preparedStatement.setBigDecimal(1, BigDecimal.valueOf(id));
                preparedStatement.setBigDecimal(2, BigDecimal.valueOf(id));
            }
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
