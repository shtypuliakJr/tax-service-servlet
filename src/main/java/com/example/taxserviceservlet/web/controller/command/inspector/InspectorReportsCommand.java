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

        else if (request.getMethod().equals("POST"))
            return reportsPost(request);

        return null;
    }

    public String reportsGet(HttpServletRequest request) {

        Long id = (Long) request.getAttribute("userId");
        Date date = (Date) request.getAttribute("date");
        TaxPeriod period = (TaxPeriod) request.getAttribute("period");
        Status status = (Status) request.getAttribute("status");
        SortField sortBy = (SortField) request.getAttribute("sortBy");

//        String idParam = request.getParameter("userId");
//        String dateParam = request.getParameter("date");
//        String periodParam = request.getParameter("period");
//        String statusParam = request.getParameter("status");
//        String sortByParam = request.getParameter("sortBy");
//        String pageNumberParam = request.getParameter("page");

//        HttpSession session = request.getSession();

//        if (!(idParam == null || idParam.isEmpty())) {
//            id = Long.valueOf(idParam);
//        }
//        if (!(dateParam == null || dateParam.isEmpty())) {
//            date = Date.valueOf(dateParam);
//        }
//        if (!(periodParam == null || periodParam.isEmpty())) {
//            period = TaxPeriod.valueOf(periodParam);
//        }
//        if (!(statusParam == null || statusParam.isEmpty())) {
//            status = Status.valueOf(statusParam);
//        }
//        if (!(sortByParam == null || sortByParam.isEmpty())) {
//            sortBy = SortField.valueOf(sortByParam);
//        }
//        if (!(pageNumberParam == null || pageNumberParam.isEmpty())) {
//            pageNumber = Integer.parseInt(pageNumberParam);
//        }
//
//        session.setAttribute("date", date);
//        session.setAttribute("period", period);
//        session.setAttribute("status", status);
//        session.setAttribute("sortBy", sortBy);

        try {
            request.setAttribute("reports", inspectorService
                    .getReportsByFilterParam(id, date, period, status, sortBy));
        } catch (NoReportsFoundException e) {
            request.setAttribute("noReportsFound", e.getMessage());
        }
        return "/inspector/reports";
    }

    public String reportsPost(HttpServletRequest request) {
        return "/inspector/reports";
    }
}
