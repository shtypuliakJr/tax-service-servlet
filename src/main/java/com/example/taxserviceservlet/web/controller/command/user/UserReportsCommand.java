package com.example.taxserviceservlet.web.controller.command.user;

import com.example.taxserviceservlet.web.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class UserReportsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        if (request.getMethod().equals("GET"))
            return reportsGet(request);

        else if (request.getMethod().equals("POST"))
            return reportsPost(request);

        return null;
    }

    public String reportsGet(HttpServletRequest request) {
        return "/user/reports";
    }

    public String reportsPost(HttpServletRequest request) {
        System.out.println("POST METHOD USER REPORTS");
        System.out.println();
        return "/user/reports";
    }

}
