package com.example.taxserviceservlet.web.controller.command.inspector;

import com.example.taxserviceservlet.web.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class InspectorStatisticCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/inspector/statistic";
    }
}
