package com.example.taxserviceservlet.dao.mapper;

import com.example.taxserviceservlet.entity.Report;
import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportMapper implements ObjectMapper<Report> {

    public Report extractFromResultSet(ResultSet resultSet) throws SQLException  {

        return Report.builder()
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

    }
}
