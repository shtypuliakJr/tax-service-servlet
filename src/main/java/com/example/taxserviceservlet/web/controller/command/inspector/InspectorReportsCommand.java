package com.example.taxserviceservlet.web.controller.command.inspector;

import com.example.taxserviceservlet.service.InspectorService;
import com.example.taxserviceservlet.web.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class InspectorReportsCommand implements Command {

    InspectorService inspectorService = InspectorService.getInstance();

    @Override
    public String execute(HttpServletRequest request) {

        if (request.getMethod().equals("GET"))
            return reportsGet(request);

        else if (request.getMethod().equals("POST"))
            return reportsPost(request);

        return null;
    }

    public String reportsGet(HttpServletRequest request) {

        return "/inspector/reports";
    }

    public String reportsPost(HttpServletRequest request) {
        System.out.println("POST METHOD INSPECTOR REPORTS");
        return "/inspector/reports";
    }

}
