package com.example.taxserviceservlet.web.controller.command.inspector;

import com.example.taxserviceservlet.exception.NoReportsFoundException;
import com.example.taxserviceservlet.service.InspectorService;
import com.example.taxserviceservlet.service.ReportService;
import com.example.taxserviceservlet.web.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class InspectorReportViewCommand implements Command {

    ReportService reportService = new ReportService();

    @Override
    public String execute(HttpServletRequest request) {

        try {
            long reportId = Long.parseLong(request.getParameter("reportId"));
            request.setAttribute("report", reportService.getReportById(reportId));
        } catch (NumberFormatException e) {
            request.setAttribute("errorInvalidParam", "Invalid parameter");
        } catch (NoReportsFoundException e) {
            request.setAttribute("noReportsFoundException", e.getMessage());
        }
        return "/inspector/report-view";
    }
}
