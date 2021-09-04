package com.example.taxserviceservlet.web.controller.command.app;

import com.example.taxserviceservlet.entity.User;
import com.example.taxserviceservlet.entity.UserRole;
import com.example.taxserviceservlet.exception.NoUserFoundException;
import com.example.taxserviceservlet.exception.WrongPasswordException;
import com.example.taxserviceservlet.service.UserService;
import com.example.taxserviceservlet.web.controller.command.Command;
import com.example.taxserviceservlet.web.controller.command.CommandUtility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

    private final UserService userService = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equals("GET"))
            return "/login";

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        try {
            session.setAttribute("user", userService.checkUserCredentials(email, password));
            User user = (User) session.getAttribute("user");
            CommandUtility.addUserToUserContext(user);
            if (user.getUserRole().equals(UserRole.USER))
                return "redirect:/user/reports";
            else if (user.getUserRole().equals(UserRole.INSPECTOR)) {
                return "redirect:/inspector/reports";
            }
        } catch (WrongPasswordException | NoUserFoundException e) {
            request.setAttribute("exception", e.getMessage());
        }
        return "/login";
    }
}
