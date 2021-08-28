package com.example.taxserviceservlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "IdFilter", value = "/filter-test")
public class IdFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;

        String id = request.getParameter("id");

        System.out.println("In filter");

        if (id == null)
            chain.doFilter(request, response);
        else {
            if (id.matches("[0-9]+")) {
                int aid = Integer.parseInt(id);
                chain.doFilter(request, response);
                System.out.println("Filter done");

            } else
                response.getWriter().println("Invalid input");


        }

    }
}
