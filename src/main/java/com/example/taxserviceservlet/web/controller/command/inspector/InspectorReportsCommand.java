package com.example.taxserviceservlet.web.controller.command.inspector;

import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;
import com.example.taxserviceservlet.exception.NoReportsFoundException;
import com.example.taxserviceservlet.service.InspectorService;
import com.example.taxserviceservlet.web.controller.command.Command;
import com.example.taxserviceservlet.web.dto.SortField;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class InspectorReportsCommand implements Command {

    InspectorService inspectorService = InspectorService.getInstance();

    @Override
    public String execute(HttpServletRequest request) {

        if (request.getMethod().equals("GET"))
            return reportsGet(request);

        return null;
    }

    public String reportsGet(HttpServletRequest request) {

        Long id = (Long) request.getAttribute("userId");
        Date date = (Date) request.getAttribute("date");
        TaxPeriod period = (TaxPeriod) request.getAttribute("period");
        Status status = (Status) request.getAttribute("status");
        SortField sortBy = (SortField) request.getAttribute("sortBy");

        try {
            request.setAttribute("reports", inspectorService
                    .getReportsByFilterParam(id, date, period, status, sortBy));
        } catch (NoReportsFoundException e) {
            request.setAttribute("noReportsFound", e.getMessage());
        }

        return "/user/reports";
    }
}
