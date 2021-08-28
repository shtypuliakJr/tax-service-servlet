package com.example.taxserviceservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@WebServlet(name = "user/reports", value = "/user/reports")
public class UserReports extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().println("hello");
        System.out.println("redirect done");
        System.out.println("Redirect param in userServlet " + request.getParameter("value"));
        System.out.println("Redirect param in session " + request.getSession().getAttribute("value"));

        Cookie[] cookies = request.getCookies();
        System.out.println("Cookies");

        Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("key")).forEach(cookie -> {
            System.out.println(cookie.getValue());
        });
        request.getRequestDispatcher("/user/reports.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
