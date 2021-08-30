package com.example.taxserviceservlet.web.controller;

import com.example.taxserviceservlet.entity.User;
import com.example.taxserviceservlet.entity.UserRole;
import com.example.taxserviceservlet.exception.NoUserFoundException;
import com.example.taxserviceservlet.exception.WrongPasswordException;
import com.example.taxserviceservlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processLogin(req, resp);
    }

    private void processLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        try {
            session.setAttribute("user", userService.checkUserCredentials(email, password));
            System.out.println("session user" + session.getAttribute("user"));
            User user = (User) session.getAttribute("user");
            if (user.getUserRole().equals(UserRole.USER))
                resp.sendRedirect("user/reports");
            else if (user.getUserRole().equals(UserRole.INSPECTOR)) {
                System.out.println("inspector");
                resp.sendRedirect("inspector/reports");
            }
//            req.getRequestDispatcher("user/reports.jsp").forward(req, resp);
//            session.setAttribute("email", email);
//            session.setAttribute("userRole", String.valueOf(user.getUserRole()));

        } catch (WrongPasswordException | NoUserFoundException e) {
            req.setAttribute("exception", e.getMessage());
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
