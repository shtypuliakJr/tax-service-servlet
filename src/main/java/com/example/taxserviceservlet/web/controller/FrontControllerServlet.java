package com.example.taxserviceservlet.web.controller;

import com.example.taxserviceservlet.web.controller.command.*;
import com.example.taxserviceservlet.web.controller.command.app.*;
import com.example.taxserviceservlet.web.controller.command.exception.ExceptionCommand;
import com.example.taxserviceservlet.web.controller.command.inspector.InspectorReportViewCommand;
import com.example.taxserviceservlet.web.controller.command.inspector.InspectorReportsCommand;
import com.example.taxserviceservlet.web.controller.command.inspector.InspectorStatisticCommand;
import com.example.taxserviceservlet.web.controller.command.inspector.InspectorUserViewCommand;
import com.example.taxserviceservlet.web.controller.command.user.UserReportsCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontControllerServlet extends HttpServlet {

    Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() {
        commands.put("", new MainCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("user/reports", new UserReportsCommand());
        commands.put("inspector/reports", new InspectorReportsCommand());
        commands.put("inspector/statistic", new InspectorStatisticCommand());
        commands.put("inspector/user-view", new InspectorUserViewCommand());
        commands.put("inspector/report-view", new InspectorReportViewCommand());
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

//        if (request.getParameter("redirect") != null) {
//            response.sendRedirect(request.getParameter("redirect"));
//            return;
//        }
        String path = request.getRequestURI().replaceFirst("/tax_service_servlet_war_exploded/", "");

        Command command = commands.getOrDefault(path.trim(), (c) -> "/error/error404");
        String page = "/error/error";

        try {
            page = command.execute(request);
        } catch (Exception exception) {
            request.setAttribute("exception", exception.getMessage());
        }
        if (page.contains("redirect")) {
            response.sendRedirect(page.replace("redirect:", "/tax_service_servlet_war_exploded"));
        } else {
            request.getRequestDispatcher(page + ".jsp").forward(request, response);
        }
    }
}
