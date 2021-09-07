package com.example.taxserviceservlet.web.controller.command.app;

import com.example.taxserviceservlet.exception.UserAlreadyExistsException;
import com.example.taxserviceservlet.service.RegistrationService;
import com.example.taxserviceservlet.web.controller.command.Command;
import com.example.taxserviceservlet.web.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class RegistrationCommand implements Command {

    private final RegistrationService registrationService = RegistrationService.getInstance();

    @Override
    public String execute(HttpServletRequest request) {

        if (request.getMethod().equals("GET"))
            return "/registration";

        UserDTO userDTO = UserDTO.builder()
                .firstName(request.getParameter("firstName"))
                .lastName(request.getParameter("lastName"))
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .age(request.getParameter("age"))
                .ipn(request.getParameter("ipn"))
                .personality(request.getParameter("personality"))
                .address(request.getParameter("address"))
                .build();

        try {
            registrationService.registerUser(userDTO);
        } catch (UserAlreadyExistsException e) {
            System.out.println("exception in servlet");
            request.setAttribute("errorUserExists", e.getMessage());
            return "/registration";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "/login";
    }
}
