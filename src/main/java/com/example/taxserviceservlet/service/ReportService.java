package com.example.taxserviceservlet.service;

import com.example.taxserviceservlet.dao.ReportsDao;
import com.example.taxserviceservlet.dao.UserDao;
import com.example.taxserviceservlet.entity.Report;
import com.example.taxserviceservlet.entity.User;
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

        Optional<Report> report = reportDao.findById(reportId);
        UserDao userDao = new UserDao();

        if (report.isPresent()) {
            Optional<User> byId = userDao.findById(report.get().getUserId());
            report.get().setUser(byId.get());
        }
//
//        reportDao.findById(reportId)
//                        .map(rep -> rep.setUser(userDao.findById(report.get().getUserId()))
//                        .orElseThrow(() -> new NoReportsFoundException("No reports found by id"));
//


        System.out.println("In service");
        System.out.println(report);
//        return reportDao.findById(reportId)
//                .map(PojoConverter::convertReportEntityToDTO)
//                .orElseThrow(() -> new NoReportsFoundException("No reports found by id"));
        return PojoConverter.convertReportEntityToDTO(report.get());
    }

}
