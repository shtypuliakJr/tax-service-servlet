package com.example.taxserviceservlet.service;

import com.example.taxserviceservlet.dao.UserDao;
import com.example.taxserviceservlet.dao.impl.UserDaoImpl;
import com.example.taxserviceservlet.entity.User;
import com.example.taxserviceservlet.exception.UserAlreadyExistsException;
import com.example.taxserviceservlet.util.PojoUtil;
import com.example.taxserviceservlet.web.dto.UserDTO;

import java.sql.SQLException;

public class RegistrationService {

    private UserDao userDao = new UserDaoImpl();

    private static RegistrationService registrationService;

    public static RegistrationService getInstance() {

        if (registrationService == null)
            registrationService = new RegistrationService();

        return registrationService;
    }

    public User registerUser(UserDTO userDTO) throws SQLException {

        if (userDao.existsByEmail(userDTO.getEmail()))
            throw new UserAlreadyExistsException("User with this email exists");

        return userDao.save(PojoUtil.convertUserDtoToEntity(userDTO));
    }
}