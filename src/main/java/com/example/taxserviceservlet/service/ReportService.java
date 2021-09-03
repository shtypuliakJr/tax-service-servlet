package com.example.taxserviceservlet.service;

import com.example.taxserviceservlet.dao.ReportsDao;
import com.example.taxserviceservlet.entity.Report;
import com.example.taxserviceservlet.exception.NoReportsFoundException;
import com.example.taxserviceservlet.util.PojoConverter;
import com.example.taxserviceservlet.web.dto.ReportDTO;

import java.util.Optional;

public class ReportService {

    ReportsDao reportDao = new ReportsDao();

    private static ReportService reportService;

    public static synchronized ReportService getInstance() {
        if (reportService == null)
            reportService = new ReportService();
        return reportService;
    }

    public ReportDTO getReportById(Long reportId) {

        Optional<Report> byId = reportDao.findById(reportId);

        System.out.println("In service");
        System.out.println(byId);
        return reportDao.findById(reportId)
                .map(PojoConverter::convertReportEntityToDTO)
                .orElseThrow(() -> new NoReportsFoundException("No reports found by id"));
    }

}
