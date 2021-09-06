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
import com.example.taxserviceservlet.util.PojoUtil;
import com.example.taxserviceservlet.web.dto.ReportDTO;
import com.example.taxserviceservlet.web.dto.SortField;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

import java.sql.Date;
import java.time.LocalDate;
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
                .map(PojoUtil::convertReportEntityToDTO)
                .collect(Collectors.toList());
    }

    public ReportDTO getReportById(Long reportId) {

        Optional<Report> report = reportDao.findById(reportId);
        UserDao userDao = new UserDaoImpl();

        if (report.isPresent()) {
            Optional<User> byId = userDao.findById(report.get().getUserId());
            report.get().setUser(byId.get());
        }

        return PojoUtil.convertReportEntityToDTO(report.get());
    }

    public boolean deleteReportById(long reportId) {
        return reportDao.delete(reportId);
    }

    public Report applyNewReport(ReportDTO reportDTO) {

        reportDTO.setStatus(String.valueOf(Status.PROCESSING));
        reportDTO.setReportDate(Date.valueOf(LocalDate.now()));

        Report report = PojoUtil.convertReportDTOToEntity(reportDTO);

        return reportDao.save(report);
    }

    public ReportDTO updateEditedReport(ReportDTO reportDTO) {

//        System.out.println(reportDTO);
//
//        Optional<Report> report = reportDao.findById(reportDTO.getId());
//
//        Report editedReport = report.map((rep) -> {
//            rep.setStatus(Status.PROCESSING);
//            rep.setIncome(reportDTO.getIncome());
//            rep.setTaxRate(reportDTO.getTaxRate());
//            rep.setTaxPeriod(TaxPeriod.valueOf(reportDTO.getTaxPeriod()));
//            rep.setYear(reportDTO.getYear());
//            return rep;
//        }).get();

        reportDao.update(PojoUtil.convertReportDTOToEntity(reportDTO));

        return reportDTO;
    }
}
