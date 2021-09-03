package com.example.taxserviceservlet.web.controller.command.inspector;

import com.example.taxserviceservlet.service.UserService;
import com.example.taxserviceservlet.web.controller.command.Command;
import com.example.taxserviceservlet.web.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;

public class InspectorUserViewCommand implements Command {

    UserService userService = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        try {
            UserDTO userDTO = userService.getUserInformationById(Long.parseLong(request.getParameter("userId")));
            request.setAttribute("userDTO", userDTO);
        } catch (NumberFormatException e) {
            request.setAttribute("errorInvalidParam", "Invalid parameter");
        }
        return "/inspector/user-view";
    }
}
