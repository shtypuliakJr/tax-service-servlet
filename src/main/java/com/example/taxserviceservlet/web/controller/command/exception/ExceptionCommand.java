package com.example.taxserviceservlet.web.controller.command.exception;

import com.example.taxserviceservlet.web.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class ExceptionCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        return "error/error";
    }
}
