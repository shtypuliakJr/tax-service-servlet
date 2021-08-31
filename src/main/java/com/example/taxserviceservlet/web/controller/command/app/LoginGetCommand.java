package com.example.taxserviceservlet.web.controller.command.app;

import com.example.taxserviceservlet.web.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class LoginGetCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("login get");
        return "/login";
    }
}
