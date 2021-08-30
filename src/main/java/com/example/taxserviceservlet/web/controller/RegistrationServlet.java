package com.example.taxserviceservlet.web.controller;

import com.example.taxserviceservlet.exception.UserAlreadyExistsException;
import com.example.taxserviceservlet.service.RegistrationService;
import com.example.taxserviceservlet.web.dto.UserDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {

    RegistrationService registrationService = new RegistrationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        processRegistration(req, resp);

    }

    private void processRegistration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDTO userDTO = new UserDTO.Builder()
                .firstName(req.getParameter("firstName"))
                .lastName(req.getParameter("lastName"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .age(req.getParameter("age"))
                .ipn(req.getParameter("ipn"))
                .personality(req.getParameter("personality"))
                .address(req.getParameter("address"))
                .build();

        System.out.println("UserDTO " + userDTO);
        try {
            registrationService.registerUser(userDTO);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } catch (UserAlreadyExistsException e) {
            System.out.println("exception in servlet");
            req.setAttribute("errorUserExists", e.getMessage());
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
        } catch (SQLException throwable) {
            req.setAttribute("error", "Exception with db");
        }
    }
}