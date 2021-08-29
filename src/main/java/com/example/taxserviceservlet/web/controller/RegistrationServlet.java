package com.example.taxserviceservlet.web.controller;

import com.example.taxserviceservlet.web.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRegistration(req, resp);

    }

    private void processRegistration(HttpServletRequest req, HttpServletResponse resp) {

        UserDTO userDTO = new UserDTO.Builder()
                .setFirstName(req.getParameter("firstName"))
                .setLastName(req.getParameter("lastName"))
                .setEmail(req.getParameter("email"))
                .setPassword(req.getParameter("password"))
                .setAge(req.getParameter("age"))
                .setIPN(req.getParameter("ipn"))
                .setPersonality(req.getParameter("personality"))
                .setAddress(req.getParameter("address"))
                .build();

        System.out.println("Params " + userDTO);
//        req.getParameterMap().forEach((k, v) -> {
//
//        });
//
//        req.getParameterMap().forEach((k, v) -> {
//            System.out.println(k + " = " + v[0]);
//        });

        System.out.println();



    }
}