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

@WebFilter("/inspector/reports")
public class ParameterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        // todo: save fer input after another page

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        String idParam = request.getParameter("userId");
        String dateParam = request.getParameter("date");
        String periodParam = request.getParameter("period");
        String statusParam = request.getParameter("status");
        String sortByParam = request.getParameter("sortBy");

        if (!(idParam == null || idParam.isEmpty())) {
            request.setAttribute("userId", Long.valueOf(idParam));
        }
        if (!(dateParam == null || dateParam.isEmpty())) {
            request.setAttribute("date", Date.valueOf(dateParam));
            session.setAttribute("date", request.getAttribute("date"));
        }
        if (!(periodParam == null || periodParam.isEmpty())) {
            request.setAttribute("period", TaxPeriod.valueOf(periodParam));
            session.setAttribute("period", request.getAttribute("period"));
        }
        if (!(statusParam == null || statusParam.isEmpty())) {
            request.setAttribute("status", Status.valueOf(statusParam));
            session.setAttribute("status", request.getAttribute("status"));
        }
        if (!(sortByParam == null || sortByParam.isEmpty())) {
            request.setAttribute("sortBy", SortField.valueOf(sortByParam));
            session.setAttribute("sortBy", request.getAttribute("sortBy"));
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
