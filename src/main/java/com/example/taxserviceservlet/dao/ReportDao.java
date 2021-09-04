package com.example.taxserviceservlet.dao;

import com.example.taxserviceservlet.entity.*;
import com.example.taxserviceservlet.web.dto.SortField;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public interface ReportDao extends Crud<Report, Long> {

    public List<Report> findByParamWithUser(Long id, Date reportDate, TaxPeriod period,
                                            Status status, SortField sortField, Integer pageNumber);

    public Map<String, Long> getStatisticDataReportsCount();

    public Map<Integer, Long> getStatisticDataReportsPerYearCount();
}
