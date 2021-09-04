package com.example.taxserviceservlet.dao;

import com.example.taxserviceservlet.entity.User;

import java.util.Map;
import java.util.Optional;

public interface UserDao extends Crud<User, Long> {

    boolean existsByEmail(String email);

    Optional<User> checkUserDetails(String email);

    Map<String, Long> getStatisticDataUsersCountByRoles();
}
