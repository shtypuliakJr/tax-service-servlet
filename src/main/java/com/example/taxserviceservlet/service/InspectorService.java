package com.example.taxserviceservlet.service;

import com.example.taxserviceservlet.dao.ReportsDao;
import com.example.taxserviceservlet.entity.Report;
import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;
import com.example.taxserviceservlet.exception.NoReportsFoundException;
import com.example.taxserviceservlet.util.PojoConverter;
import com.example.taxserviceservlet.web.dto.ReportDTO;
import com.example.taxserviceservlet.web.dto.SortField;
import com.example.taxserviceservlet.web.dto.StatisticDTO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class InspectorService {

    ReportsDao reportsDao = new ReportsDao();
    private static InspectorService inspectorService;

    public static InspectorService getInstance() {
        if (inspectorService == null)
            inspectorService = new InspectorService();
        return inspectorService;
    }


    public List<ReportDTO> getReportsByFilterParam(Long id, Date reportDate, TaxPeriod period,
                                                   Status status, SortField sortField) {

        List<Report> reportList = null;

        try {
            reportList = reportsDao.findByParam(id, reportDate, period, status, sortField);
            System.out.println("after dao");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (reportList == null || reportList.isEmpty())
            throw new NoReportsFoundException("No reports found");

        System.out.println(reportList);
        return reportList.stream()
                .map(PojoConverter::convertReportEntityToDTO)
                .collect(Collectors.toList());
    }

    public List<ReportDTO> getReportsBySearchParam() {
        return null;
    }

    public StatisticDTO getStatisticData() {

        return new StatisticDTO.Builder();
    }

    public ReportDTO setReportStatus(ReportDTO reportsDTO) {
        return null;
    }


}
