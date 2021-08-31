package com.example.taxserviceservlet.web.controller.command;

import com.example.taxserviceservlet.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

public class CommandUtility {

//    public static boolean checkUserIsLogged(HttpServletRequest request, String email) {
//
//        ServletContext servletContext = request.getSession().getServletContext();
//
//        HashSet<User> loggedUsers = (HashSet<User>) servletContext.getAttribute("loggedUsers");
//
//        if (loggedUsers.stream().anyMatch(email::equals)) {
//            return true;
//        }
//        loggedUsers.add(email);
//        servletContext.setAttribute("loggedUsers", loggedUsers);
//        return false;
//    }

}
