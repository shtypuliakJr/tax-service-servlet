package com.example.taxserviceservlet.service;

import com.example.taxserviceservlet.dao.UserDao;
import com.example.taxserviceservlet.entity.User;
import com.example.taxserviceservlet.exception.UserAlreadyExistsException;
import com.example.taxserviceservlet.util.PojoConverter;
import com.example.taxserviceservlet.web.dto.UserDTO;

import java.sql.SQLException;

public class RegistrationService {

    private UserDao userDao = new UserDao();
    private static RegistrationService registrationService;

    public static RegistrationService getInstance() {
        if (registrationService == null) {
            registrationService = new RegistrationService();
        }
        return registrationService;
    }

    public User registerUser(UserDTO userDTO) throws SQLException {
        if (userDao.existsByEmail(userDTO.getEmail())) {
            System.out.println("true in service");
            throw new UserAlreadyExistsException("User with this email exists");
        }
        return userDao.save(PojoConverter.convertUserDtoToEntity(userDTO));

    }
}

//public class StudentService {
//
//    DaoFactory daoFactory = DaoFactory.getInstance();
//
//    public List<Student> getAllStudents(){
//        try (StudentDao dao = daoFactory.createStudentDao()) {
//            return dao.findAll();
//        }
//    }
//}
