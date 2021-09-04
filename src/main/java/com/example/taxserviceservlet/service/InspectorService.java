package com.example.taxserviceservlet.service;

import com.example.taxserviceservlet.dao.ReportDao;
import com.example.taxserviceservlet.dao.UserDao;
import com.example.taxserviceservlet.dao.impl.ReportDaoImpl;
import com.example.taxserviceservlet.dao.impl.UserDaoImpl;
import com.example.taxserviceservlet.entity.Report;
import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;
import com.example.taxserviceservlet.exception.NoReportsFoundException;
import com.example.taxserviceservlet.exception.ReportStatusException;
import com.example.taxserviceservlet.util.PojoConverter;
import com.example.taxserviceservlet.web.dto.ReportDTO;
import com.example.taxserviceservlet.web.dto.SortField;
import com.example.taxserviceservlet.web.dto.StatisticDTO;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InspectorService {

    ReportDao reportDao = new ReportDaoImpl();
    UserDao userDao = new UserDaoImpl();


    private static InspectorService inspectorService;

    public static InspectorService getInstance() {
        if (inspectorService == null)
            inspectorService = new InspectorService();

        return inspectorService;
    }


    public List<ReportDTO> getReportsByFilterParam(Long id, Date reportDate, TaxPeriod period,
                                                   Status status, SortField sortField) {

        List<Report> reportList = null;

        reportList = reportDao.findByParamWithUser(id, reportDate, period, status, sortField);


        if (reportList == null || reportList.isEmpty())
            throw new NoReportsFoundException("No reports found");

        return reportList.stream()
                .map(PojoConverter::convertReportEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ReportDTO> getReportsBySearchParam() {
        return null;
    }

    public StatisticDTO getStatisticData() {

        Map<String, Long> statisticDataReportsCount = reportDao.getStatisticDataReportsCount();

        Map<Integer, Long> statisticDataReportsPerYearCount = reportDao.getStatisticDataReportsPerYearCount();

        Map<String, Long> statisticDataUsersCountByRoles = userDao.getStatisticDataUsersCountByRoles();

        return StatisticDTO.builder()
                .countOfReports(statisticDataReportsCount.get("count"))
                .processingReports(statisticDataReportsCount.get("processing_count"))
                .approvedReports(statisticDataReportsCount.get("approved_count"))
                .disapprovedReports(statisticDataReportsCount.get("disapproved_count"))
                .countReportsPerYear(statisticDataReportsPerYearCount)
                .countOfUsers(statisticDataUsersCountByRoles.get("user_count"))
                .countOfInspectors(statisticDataUsersCountByRoles.get("inspector_count"))
                .build();
    }

    public Report setReportStatus(ReportDTO reportDTO, String status, String comment) {

        if (status == null || status.isEmpty())
            throw new ReportStatusException("Require status");

        System.out.println("1");
        System.out.println("Status in service " + Status.valueOf(status));
        if (Status.valueOf(status).equals(Status.DISAPPROVED) && comment == null)
            throw new ReportStatusException("Require comment");

        reportDTO.setComment(comment);
        reportDTO.setStatus(status);
        System.out.println("2");

        return reportDao.update(PojoConverter.convertReportDTOToEntity(reportDTO));
    }
}
