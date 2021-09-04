package com.example.taxserviceservlet.dao;

import com.example.taxserviceservlet.dao.mapper.UserMapper;
import com.example.taxserviceservlet.entity.Personality;
import com.example.taxserviceservlet.entity.User;
import com.example.taxserviceservlet.entity.UserRole;
import com.example.taxserviceservlet.web.dto.UserDTO;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public interface UserDao extends Crud<User, Long> {

    boolean existsByEmail(String email);

    public Optional<User> checkUserDetails(String email);

    public Map<String, Long> getStatisticDataUsersCountByRoles();
}
