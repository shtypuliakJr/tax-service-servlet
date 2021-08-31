package com.example.taxserviceservlet.service;

import com.example.taxserviceservlet.dao.UserDao;
import com.example.taxserviceservlet.entity.User;
import com.example.taxserviceservlet.exception.NoUserFoundException;
import com.example.taxserviceservlet.exception.WrongPasswordException;
import com.example.taxserviceservlet.web.dto.UserDTO;

import java.util.Optional;

public class UserService {

    UserDao userDao = new UserDao();
    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public User checkUserCredentials(String email, String password)
            throws WrongPasswordException, NoUserFoundException {

        Optional<User> userDTO = userDao.checkUserDetails(email);
        if (userDTO.isPresent()) {
            if (!userDTO.get().getPassword().equals(password)) {
                throw new WrongPasswordException("Wrong password");
            }
        }
        return userDTO.orElseThrow(() -> new NoUserFoundException("No such user found"));
    }
}
