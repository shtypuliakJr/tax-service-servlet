package com.example.taxserviceservlet.web.controller.command.user;

import com.example.taxserviceservlet.service.ReportService;
import com.example.taxserviceservlet.web.controller.command.Command;
import com.example.taxserviceservlet.web.dto.ReportDTO;
import com.example.taxserviceservlet.web.dto.ReportFormError;

import javax.servlet.http.HttpServletRequest;

public class UserReportApplyCommand implements Command {

    private final ReportService reportService = ReportService.getInstance();

    @Override
    public String execute(HttpServletRequest request) {

        if (request.getMethod().equals("GET")) {
            return processGetRequest(request);
        } else {
            return processPostRequest(request);
        }
    }

    private String processGetRequest(HttpServletRequest request) {

        return "/user/report-form";
    }

    private String processPostRequest(HttpServletRequest request) {

        ReportFormError formError = (ReportFormError) request.getAttribute("errorReportFormDTO");

        if (formError.hasErrors()) {
            request.setAttribute("fields", formError);
            return "/user/report-form";
        }

        ReportDTO report = (ReportDTO) request.getAttribute("reportDTO");
        reportService.applyNewReport(report);

        return "redirect:/user/reports";
    }
}
