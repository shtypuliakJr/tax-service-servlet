package com.example.taxserviceservlet.service;

import com.example.taxserviceservlet.dao.ReportsDao;
import com.example.taxserviceservlet.dao.UserDao;
import com.example.taxserviceservlet.entity.Report;
import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;
import com.example.taxserviceservlet.exception.NoReportsFoundException;
import com.example.taxserviceservlet.util.PojoConverter;
import com.example.taxserviceservlet.web.dto.ReportDTO;
import com.example.taxserviceservlet.web.dto.SortField;
import com.example.taxserviceservlet.web.dto.StatisticDTO;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InspectorService {

    ReportsDao reportsDao = new ReportsDao();
    UserDao userDao = new UserDao();


    private static InspectorService inspectorService;

    public static InspectorService getInstance() {
        if (inspectorService == null)
            inspectorService = new InspectorService();
        return inspectorService;
    }


    public List<ReportDTO> getReportsByFilterParam(Long id, Date reportDate, TaxPeriod period,
                                                   Status status, SortField sortField, Integer pageNumber) {

        List<Report> reportList = null;

        try {
            reportList = reportsDao.findByParamWithUser(id, reportDate, period, status, sortField, pageNumber);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

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

        Map<String, Long> statisticDataReportsCount = reportsDao.getStatisticDataReportsCount();

        Map<Integer, Long> statisticDataReportsPerYearCount = reportsDao.getStatisticDataReportsPerYearCount();

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

    public ReportDTO setReportStatus(ReportDTO reportsDTO) {
        return null;
    }


}
