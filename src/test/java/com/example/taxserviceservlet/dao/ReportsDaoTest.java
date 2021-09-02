package com.example.taxserviceservlet.dao;

import com.example.taxserviceservlet.entity.Report;
import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;
import com.example.taxserviceservlet.web.dto.SortField;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReportsDaoTest {

    ReportsDao reportsDao = new ReportsDao();

    @Test
    void find_reports_by_param(Long id, Date reportDate, TaxPeriod period,
                               Status status, SortField sortField) throws SQLException {

        List<Report> byParam = reportsDao.findByParam(id, reportDate, period, status, sortField);
        System.out.println(byParam);
    }
}