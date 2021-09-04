package com.example.taxserviceservlet.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/inspector/reports")
public class ParameterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        // todo: save fer input after another page
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String userId = request.getParameter("userId");
        //ToDo: filter input parameters
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
