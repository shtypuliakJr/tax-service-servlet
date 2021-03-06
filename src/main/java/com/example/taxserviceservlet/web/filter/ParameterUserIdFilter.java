package com.example.taxserviceservlet.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/inspector/reports")
public class ParameterUserIdFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        String idParam = request.getParameter("userId");

        if (idParam != null)
            session.setAttribute("userId", idParam.isEmpty() ? null : Long.valueOf(idParam));

        request.setAttribute("userId", session.getAttribute("userId"));

        filterChain.doFilter(servletRequest, servletResponse);
    }
}