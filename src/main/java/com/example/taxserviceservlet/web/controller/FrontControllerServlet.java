package com.example.taxserviceservlet.web.controller;

import com.example.taxserviceservlet.web.controller.command.*;
import com.example.taxserviceservlet.web.controller.command.app.*;
import com.example.taxserviceservlet.web.controller.command.exception.ExceptionCommand;
import com.example.taxserviceservlet.web.controller.command.user.UserReportsCommand;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontControllerServlet extends HttpServlet {

    Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() throws ServletException {
        commands.put("", new MainCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("login", new LoginGetCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("userReports", new UserReportsCommand());
        commands.put("error", new ExceptionCommand());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (request.getParameter("redirect") != null) {
            response.sendRedirect(request.getParameter("redirect"));
            return;
        }
        System.out.println("URI " + request.getRequestURI());
        String path = request.getRequestURI().replaceFirst("/tax_service_servlet_war_exploded/", "");
        System.out.println("Path " + path);
        System.out.println("Path " + path.isEmpty());
        Command command = commands.getOrDefault(path, (c) -> "");
        String page = "/error";
        try {
            System.out.println("before execute");
            page = command.execute(request);
        } catch (Exception exception) {
            request.setAttribute("errorMessage", exception.getMessage());
        }
        System.out.println("Page " + page);
        if (page.contains("redirect")) {
            response.sendRedirect(page.replace("redirect:", ""));
        } else {
            System.out.println("request dispatcher");
            System.out.println("Final page " + page + ".jsp");
            request.getRequestDispatcher("/" + page + ".jsp").forward(request, response);
        }
    }
}
