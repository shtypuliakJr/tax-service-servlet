package com.example.taxserviceservlet.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

@WebFilter(urlPatterns = "/registration")
public class RegistrationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("in reg filter");
        AtomicBoolean isParamCorrect = new AtomicBoolean(true);
        servletRequest.getParameterMap().forEach((k, v) -> {
            if (v[0].equals("")) {
                System.out.println("filtered " + k);
                isParamCorrect.set(false);
            } else {
                System.out.println("Param norm " + k + " " + v[0]);
            }
        });

        if (isParamCorrect.get())
            filterChain.doFilter(servletRequest, servletResponse);
        else {
            servletRequest.getParameterMap().forEach(servletRequest::setAttribute);
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/registration.jsp");

            try {
                requestDispatcher.forward(servletRequest, servletResponse);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
