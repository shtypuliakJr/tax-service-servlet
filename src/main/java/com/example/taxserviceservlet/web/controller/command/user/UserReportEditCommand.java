package com.example.taxserviceservlet.web.controller.command.user;

import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.service.ReportService;
import com.example.taxserviceservlet.web.controller.command.Command;
import com.example.taxserviceservlet.web.dto.ReportDTO;
import com.example.taxserviceservlet.web.dto.ReportFormError;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserReportEditCommand implements Command {

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

        Long reportId = Long.valueOf(request.getParameter("reportId"));
        ReportDTO reportById = reportService.getReportById(reportId);

        request.getSession().setAttribute("reportById", reportById);

        return "/WEB-INF/user/report-edit";
    }

    private String processPostRequest(HttpServletRequest request) {

        ReportFormError formError = (ReportFormError) request.getAttribute("errorReportFormDTO");

        if (formError.hasErrors()) {
            request.setAttribute("fields", formError);
            return "/WEB-INF/user/report-form";
        }

        HttpSession session = request.getSession();

        ReportDTO initialReport = (ReportDTO) session.getAttribute("reportById");
        ReportDTO reportDTO = (ReportDTO) request.getAttribute("reportDTO");

        initialReport.setIncome(reportDTO.getIncome());
        initialReport.setTaxRate(reportDTO.getTaxRate());
        initialReport.setStatus(String.valueOf(Status.PROCESSING));
        initialReport.setTaxPeriod(reportDTO.getTaxPeriod());
        initialReport.setYear(reportDTO.getYear());

        reportService.updateEditedReport(reportDTO);

        session.removeAttribute("reportById");

        return "redirect:/user/reports";
    }
}
