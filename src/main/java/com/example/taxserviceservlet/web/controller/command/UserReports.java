package com.example.taxserviceservlet.web.controller.command;

import javax.servlet.http.HttpServletRequest;

public class UserReports implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        return "/user/reports.jsp";
    }
}
