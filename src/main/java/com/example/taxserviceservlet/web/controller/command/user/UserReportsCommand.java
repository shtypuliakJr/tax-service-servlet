package com.example.taxserviceservlet.web.controller.command.user;

import com.example.taxserviceservlet.web.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class UserReportsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/user/reports";
    }
}
