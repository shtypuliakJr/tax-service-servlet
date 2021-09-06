package com.example.taxserviceservlet.service;

import com.example.taxserviceservlet.dao.ReportDao;
import com.example.taxserviceservlet.dao.UserDao;
import com.example.taxserviceservlet.dao.impl.ReportDaoImpl;
import com.example.taxserviceservlet.dao.impl.UserDaoImpl;
import com.example.taxserviceservlet.entity.Report;
import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;
import com.example.taxserviceservlet.entity.User;
import com.example.taxserviceservlet.exception.NoReportsFoundException;
import com.example.taxserviceservlet.util.PojoConverter;
import com.example.taxserviceservlet.web.dto.ReportDTO;
import com.example.taxserviceservlet.web.dto.SortField;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReportService {

    ReportDao reportDao = new ReportDaoImpl();

    private static ReportService reportService;

    public static synchronized ReportService getInstance() {
        if (reportService == null)
            reportService = new ReportService();
        return reportService;
    }

    public List<ReportDTO> getReportsByFilterParam(Long id, Date reportDate, TaxPeriod period,
                                                   Status status, SortField sortField) {

        List<Report> reportList;

        reportList = reportDao.findByParam(id, reportDate, period, status, sortField);

        if (reportList == null || reportList.isEmpty())
            throw new NoReportsFoundException("No reports found");

        return reportList.stream()
                .map(PojoConverter::convertReportEntityToDTO)
                .collect(Collectors.toList());
    }

    public ReportDTO getReportById(Long reportId) {

        Optional<Report> report = reportDao.findById(reportId);
        UserDao userDao = new UserDaoImpl();

        if (report.isPresent()) {
            Optional<User> byId = userDao.findById(report.get().getUserId());
            report.get().setUser(byId.get());
        }

        return PojoConverter.convertReportEntityToDTO(report.get());
    }

    public boolean deleteReportById(long reportId) {
        return reportDao.delete(reportId);
    }

    public Report applyNewReport(ReportDTO reportDTO) {

        reportDTO.setStatus(String.valueOf(Status.PROCESSING));
        reportDTO.setReportDate(Date.valueOf(LocalDate.now()));

        Report report = PojoConverter.convertReportDTOToEntity(reportDTO);

//        report.setReportDate(Date.valueOf(LocalDate.now()));

        return reportDao.save(report);
    }
}
