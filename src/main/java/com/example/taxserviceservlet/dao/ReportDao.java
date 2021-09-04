package com.example.taxserviceservlet.dao;

import com.example.taxserviceservlet.entity.Report;
import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;
import com.example.taxserviceservlet.web.dto.SortField;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface ReportDao extends Crud<Report, Long> {

    List<Report> findByParamWithUser(Long id, Date reportDate, TaxPeriod period,
                                     Status status, SortField sortField);

    Map<String, Long> getStatisticDataReportsCount();

    Map<Integer, Long> getStatisticDataReportsPerYearCount();
}