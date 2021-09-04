package com.example.taxserviceservlet.dao.mapper;

import com.example.taxserviceservlet.entity.Personality;
import com.example.taxserviceservlet.entity.User;
import com.example.taxserviceservlet.entity.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ObjectMapper<User>{

    public User extractFromResultSet(ResultSet resultSet) throws SQLException {
        return User.builder()
                .userId(resultSet.getLong("id"))
                .firstName(resultSet.getString("first_name"))
                .lastName(resultSet.getString("last_name"))
                .email(resultSet.getString("email"))
                .password(resultSet.getString("user_password"))
                .age(resultSet.getInt("age"))
                .userRole(UserRole.valueOf(resultSet.getString("user_role")))
                .address(resultSet.getString("address"))
                .personality(Personality.valueOf(resultSet.getString("personality")))
                .ipn(resultSet.getString("ipn"))
                .dateOfRegistration(resultSet.getDate("date"))
                .build();
    }

    public static User extractUserFromResultSetForReport(ResultSet resultSet) throws SQLException {
        return User.builder()
                .userId(resultSet.getLong("user_id"))
                .firstName(resultSet.getString("first_name"))
                .lastName(resultSet.getString("last_name"))
                .ipn(resultSet.getString("ipn"))
                .build();
    }

}
