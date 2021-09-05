package com.example.taxserviceservlet.web.controller;

import com.example.taxserviceservlet.web.controller.command.Command;
import com.example.taxserviceservlet.web.controller.command.user.*;
import com.example.taxserviceservlet.web.controller.command.app.LoginCommand;
import com.example.taxserviceservlet.web.controller.command.app.LogoutCommand;
import com.example.taxserviceservlet.web.controller.command.app.MainCommand;
import com.example.taxserviceservlet.web.controller.command.app.RegistrationCommand;
import com.example.taxserviceservlet.web.controller.command.exception.ExceptionCommand;
import com.example.taxserviceservlet.web.controller.command.inspector.InspectorReportViewCommand;
import com.example.taxserviceservlet.web.controller.command.inspector.InspectorReportsCommand;
import com.example.taxserviceservlet.web.controller.command.inspector.InspectorStatisticCommand;
import com.example.taxserviceservlet.web.controller.command.inspector.InspectorUserViewCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontControllerServlet extends HttpServlet {

    private final Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() {

        commands.put("", new MainCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());

        commands.put("user/reports", new UserReportsCommand());
        commands.put("user/user-info", new UserInfoCommand());
        commands.put("user/report-form", new UserReportApplyCommand());
        commands.put("user/report-edit", new UserReportEditCommand());
        commands.put("user/report-delete", new UserReportDeleteCommand());

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

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String path = request.getRequestURI().replaceFirst("/", "");
        Command command = commands.getOrDefault(path.trim(), (c) -> "/error/error404");
        String page = "/error/error";

        try {
            page = command.execute(request);
        } catch (Exception exception) {
            request.setAttribute("exception", exception.getMessage());
        }

        if (page.contains("redirect:")) {
            response.sendRedirect(page.replace("redirect:", ""));
        } else {
            request.getRequestDispatcher(page + ".jsp").forward(request, response);
        }
    }
}
