package com.example.taxserviceservlet.service;

import com.example.taxserviceservlet.dao.ReportsDao;
import com.example.taxserviceservlet.web.dto.ReportDTO;
import com.example.taxserviceservlet.web.dto.StatisticDTO;

import java.util.List;

public class InspectorService {

    ReportsDao reportsDao = new ReportsDao();
    private static InspectorService inspectorService;

    public static InspectorService getInstance() {
        if (inspectorService == null)
            inspectorService = new InspectorService();
        return inspectorService;
    }


    public List<ReportDTO> getReportsByFilterParam() {
        return null;
    }

    public List<ReportDTO> getReportsBySearchParam() {
        return null;
    }

    public StatisticDTO getStatisticData() {

        return new StatisticDTO.Builder()
    }

    public ReportDTO setReportStatus(ReportsDTO reportsDTO) {
        return null;
    }


}
