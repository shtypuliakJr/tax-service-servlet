package com.example.taxserviceservlet.service;

import com.example.taxserviceservlet.dao.DaoFactory;
import com.example.taxserviceservlet.dao.ReportDao;
import com.example.taxserviceservlet.dao.UserDao;
import com.example.taxserviceservlet.dao.impl.ReportDaoImpl;
import com.example.taxserviceservlet.dao.impl.UserDaoImpl;
import com.example.taxserviceservlet.entity.Report;
import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;
import com.example.taxserviceservlet.exception.NoReportsFoundException;
import com.example.taxserviceservlet.exception.ReportStatusException;
import com.example.taxserviceservlet.util.PojoUtil;
import com.example.taxserviceservlet.web.dto.ReportDTO;
import com.example.taxserviceservlet.web.dto.SortField;
import com.example.taxserviceservlet.web.dto.StatisticDTO;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InspectorService {

    private final ReportDao reportDao = DaoFactory.getReportDaoInstance();
    private final UserDao userDao = DaoFactory.getUserDaoInstance();

    private static InspectorService inspectorService;

    public static synchronized InspectorService getInstance() {
        if (inspectorService == null)
            inspectorService = new InspectorService();

        return inspectorService;
    }

    public List<ReportDTO> getReportsByFilterParam(Long id, Date reportDate, TaxPeriod period,
                                                   Status status, SortField sortField) {

        List<Report> reportList;

        reportList = reportDao.findByParamWithUser(id, reportDate, period, status, sortField);


        if (reportList == null || reportList.isEmpty())
            throw new NoReportsFoundException("No reports found");

        return reportList.stream()
                .map((report) -> PojoUtil.convertReportEntityToDTO(report, report.getUser()))
                .collect(Collectors.toList());
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

        if (Status.valueOf(status).equals(Status.DISAPPROVED) && comment.isEmpty())
            throw new ReportStatusException("Require comment");

        reportDTO.setComment(comment.trim());
        reportDTO.setStatus(status);

        return reportDao.update(PojoUtil.convertReportDTOToEntity(reportDTO));
    }
}
