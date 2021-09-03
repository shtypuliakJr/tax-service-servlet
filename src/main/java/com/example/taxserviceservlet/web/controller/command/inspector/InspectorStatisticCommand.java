package com.example.taxserviceservlet.web.controller.command.inspector;

import com.example.taxserviceservlet.service.InspectorService;
import com.example.taxserviceservlet.web.controller.command.Command;
import com.example.taxserviceservlet.web.dto.StatisticDTO;

import javax.servlet.http.HttpServletRequest;

public class InspectorStatisticCommand implements Command {

    InspectorService inspectorService = InspectorService.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("statisticData", inspectorService.getStatisticData());
        System.out.println(inspectorService.getStatisticData());
        return "/inspector/statistic";
    }
}
