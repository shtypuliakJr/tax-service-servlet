package com.example.taxserviceservlet.service;

import com.example.taxserviceservlet.dao.ReportDao;
import com.example.taxserviceservlet.dao.UserDao;
import com.example.taxserviceservlet.dao.impl.ReportDaoImpl;
import com.example.taxserviceservlet.dao.impl.UserDaoImpl;
import com.example.taxserviceservlet.entity.Report;
import com.example.taxserviceservlet.entity.User;
import com.example.taxserviceservlet.util.PojoConverter;
import com.example.taxserviceservlet.web.dto.ReportDTO;

import java.util.Optional;

public class ReportService {

    ReportDao reportDao = new ReportDaoImpl();

    private static ReportService reportService;

    public static synchronized ReportService getInstance() {
        if (reportService == null)
            reportService = new ReportService();
        return reportService;
    }

    public ReportDTO getReportById(Long reportId) {

        Optional<Report> report = reportDao.findById(reportId);
        UserDao userDao = new UserDaoImpl();

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
