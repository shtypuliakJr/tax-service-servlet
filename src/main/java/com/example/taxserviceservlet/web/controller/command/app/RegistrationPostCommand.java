package com.example.taxserviceservlet.web.controller.command.app;

import com.example.taxserviceservlet.exception.UserAlreadyExistsException;
import com.example.taxserviceservlet.web.controller.command.Command;
import com.example.taxserviceservlet.web.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class RegistrationPostCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

//        UserDTO userDTO = new UserDTO.Builder()
//                .firstName(request.getParameter("firstName"))
//                .lastName(request.getParameter("lastName"))
//                .email(request.getParameter("email"))
//                .password(request.getParameter("password"))
//                .age(request.getParameter("age"))
//                .ipn(request.getParameter("ipn"))
//                .personality(request.getParameter("personality"))
//                .address(request.getParameter("address"))
//                .build();
//
//        System.out.println("UserDTO " + userDTO);
//        try {
//            registrationService.registerUser(userDTO);
//            request.getRequestDispatcher("login.jsp").forward(req, resp);
//        } catch (UserAlreadyExistsException e) {
//            System.out.println("exception in servlet");
//            request.setAttribute("errorUserExists", e.getMessage());
//            request.getRequestDispatcher("registration.jsp").forward(req, resp);
//        } catch (SQLException throwable) {
//            request.setAttribute("error", "Exception with db");
//        }
        return null;
    }
}
