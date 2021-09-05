package com.example.taxserviceservlet.web.controller.command.user;

import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;
import com.example.taxserviceservlet.entity.User;
import com.example.taxserviceservlet.exception.NoReportsFoundException;
import com.example.taxserviceservlet.service.ReportService;
import com.example.taxserviceservlet.web.controller.command.Command;
import com.example.taxserviceservlet.web.dto.SortField;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class UserReportsCommand implements Command {

    ReportService reportService = ReportService.getInstance();

    @Override
    public String execute(HttpServletRequest request) {

        Long id = ((User) request.getSession().getAttribute("user")).getUserId();
        Date date = (Date) request.getAttribute("date");
        TaxPeriod period = (TaxPeriod) request.getAttribute("period");
        Status status = (Status) request.getAttribute("status");
        SortField sortBy = (SortField) request.getAttribute("sortBy");


        try {
            request.setAttribute("reports",
                    reportService.getReportsByFilterParam(id, date, period, status, sortBy));
        } catch (NoReportsFoundException e) {
            request.setAttribute("noReportsFoundException", e.getMessage());
        }

        System.out.println(id + " " + date);
        return "/user/reports";
    }
}
