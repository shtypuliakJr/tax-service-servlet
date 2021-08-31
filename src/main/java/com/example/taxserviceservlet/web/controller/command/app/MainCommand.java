package com.example.taxserviceservlet.web.controller.command.app;

import com.example.taxserviceservlet.web.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class MainCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "index";
    }
}
