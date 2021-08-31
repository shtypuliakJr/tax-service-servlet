package com.example.taxserviceservlet.service;

public class ServiceContainer {

    static UserService userService;

    public static UserService getUserServiceInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }
}
