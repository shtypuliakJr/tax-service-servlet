package com.example.taxserviceservlet.web.controller.command.user;

import com.example.taxserviceservlet.web.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class UserReportEditCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        if (request.getMethod().equals("GET")) {
            return processGetRequest(request);
        } else {
            return processPostRequest(request);
        }
    }

    private String processGetRequest(HttpServletRequest request) {

        return "/user/report-edit";
    }

    private String processPostRequest(HttpServletRequest request) {

        return "redirect:/user/reports";
    }
}