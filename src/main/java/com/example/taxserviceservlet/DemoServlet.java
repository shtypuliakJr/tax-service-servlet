package com.example.taxserviceservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DemoServlet", value = "/user/reports-view")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = "Arthur123";
        List<String> users = new ArrayList<>();

        users.add("User 1");
        users.add("User 2");
        users.add("User 3");

        req.setAttribute("users", users);
        req.setAttribute("reportName", name);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/reports-view.jsp");
        requestDispatcher.forward(req,resp);


    }
}
