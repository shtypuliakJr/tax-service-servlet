package com.example.taxserviceservlet.web.filter;

import com.example.taxserviceservlet.entity.Status;
import com.example.taxserviceservlet.entity.TaxPeriod;
import com.example.taxserviceservlet.web.dto.SortField;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebFilter(value = {"/user/reports", "/inspector/reports"})
public class ParameterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        String dateParam = request.getParameter("date");
        String periodParam = request.getParameter("period");
        String statusParam = request.getParameter("status");
        String sortByParam = request.getParameter("sortBy");

        if (dateParam != null)
            session.setAttribute("date", dateParam.isEmpty() ? null : Date.valueOf(dateParam));

        if (periodParam != null)
            session.setAttribute("period", periodParam.isEmpty() ? null : TaxPeriod.valueOf(periodParam));

        if (statusParam != null)
            session.setAttribute("status", statusParam.isEmpty() ? null : Status.valueOf(statusParam));

        if (sortByParam != null)
            session.setAttribute("sortBy", sortByParam.isEmpty() ? null : SortField.valueOf(sortByParam));

        request.setAttribute("date", session.getAttribute("date"));
        request.setAttribute("period", session.getAttribute("period"));
        request.setAttribute("status", session.getAttribute("status"));
        request.setAttribute("sortBy", session.getAttribute("sortBy"));

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
