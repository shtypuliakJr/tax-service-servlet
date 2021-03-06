package com.example.taxserviceservlet.service;

import com.example.taxserviceservlet.dao.DaoFactory;
import com.example.taxserviceservlet.dao.UserDao;
import com.example.taxserviceservlet.dao.impl.UserDaoImpl;
import com.example.taxserviceservlet.entity.User;
import com.example.taxserviceservlet.exception.NoUserFoundException;
import com.example.taxserviceservlet.exception.WrongPasswordException;
import com.example.taxserviceservlet.util.PojoUtil;
import com.example.taxserviceservlet.web.dto.UserDTO;

import java.util.Optional;

public class UserService {

    private final UserDao userDao = DaoFactory.getUserDaoInstance();

    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public User checkUserPrincipal(String email, String password)
            throws WrongPasswordException, NoUserFoundException {

        Optional<User> user = userDao.checkUserDetails(email);

        if (user.isPresent()) {
            if (!(user.get().getPassword().equals(password))) {
                throw new WrongPasswordException("Wrong password");
            }
        }
        return user.orElseThrow(() -> new NoUserFoundException("No such user found"));
    }

    public UserDTO getUserInformationById(Long userId) throws NoUserFoundException {

        return userDao.findById(userId)
                .map(PojoUtil::convertUserEntityToDto)
                .orElseThrow(() -> new NoUserFoundException("No user found by id"));

    }
}
