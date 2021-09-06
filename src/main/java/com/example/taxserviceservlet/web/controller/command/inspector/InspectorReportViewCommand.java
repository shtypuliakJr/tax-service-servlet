package com.example.taxserviceservlet.web.controller.command.inspector;

import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.exception.NoReportsFoundException;
import com.example.taxserviceservlet.exception.ReportStatusException;
import com.example.taxserviceservlet.service.InspectorService;
import com.example.taxserviceservlet.service.ReportService;
import com.example.taxserviceservlet.web.controller.command.Command;
import com.example.taxserviceservlet.web.dto.ReportDTO;

import javax.servlet.http.HttpServletRequest;

public class InspectorReportViewCommand implements Command {

    private final ReportService reportService = ReportService.getInstance();
    private final InspectorService inspectorService = InspectorService.getInstance();

    @Override
    public String execute(HttpServletRequest request) {

        if (request.getMethod().equals("GET")) {
            return processGetMethod(request);
        } else if (request.getMethod().equals("POST")) {
            return processPostMethod(request);
        }
        return null;
    }

    private String processPostMethod(HttpServletRequest request) {

        String status = request.getParameter("status");
        String comment = request.getParameter("comment");
        ReportDTO report = (ReportDTO) request.getSession().getAttribute("report");
        report.setComment(comment);
        report.setStatus(status);

        try {
            inspectorService.setReportStatus(report, status, comment);
        } catch (ReportStatusException e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("comment", comment);
            return "/WEB-INF/inspector/report-view";
        }
        return "redirect:/inspector/reports";
    }

    public String processGetMethod(HttpServletRequest request) {

        try {
            long reportId = Long.parseLong(request.getParameter("reportId"));
            ReportDTO report = reportService.getReportById(reportId);
            request.getSession().setAttribute("report", report);
        } catch (NumberFormatException e) {
            request.setAttribute("errorInvalidParam", "Invalid parameter");
        } catch (NoReportsFoundException e) {
            request.setAttribute("noReportsFoundException", e.getMessage());
        }
        return "/WEB-INF/inspector/report-view";
    }
}
