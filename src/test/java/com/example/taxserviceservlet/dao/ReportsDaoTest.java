package com.example.taxserviceservlet.dao;

import com.example.taxserviceservlet.dao.impl.ReportDaoImpl;
import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;
import com.example.taxserviceservlet.web.dto.SortField;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Date;

class ReportsDaoTest {

    ReportDao reportDao = new ReportDaoImpl();

    @Test
    void find_reports_by_param(Long id, Date reportDate, TaxPeriod period,
                               Status status, SortField sortField) throws SQLException {
//
//        List<Report> byParam = reportsDao.findByParam(id, reportDate, period, status, sortField);
//        System.out.println(byParam);
    }
}