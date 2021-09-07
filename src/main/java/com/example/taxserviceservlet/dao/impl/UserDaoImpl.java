package com.example.taxserviceservlet.dao.impl;

import com.example.taxserviceservlet.dao.DaoConnector;
import com.example.taxserviceservlet.dao.UserDao;
import com.example.taxserviceservlet.dao.mapper.ObjectMapper;
import com.example.taxserviceservlet.dao.mapper.UserMapper;
import com.example.taxserviceservlet.entity.User;

import java.sql.Date;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class UserDaoImpl implements UserDao {

    ObjectMapper<User> mapper = new UserMapper();

    @Override
    public List<User> findAll() {

        String queryFindAll = "SELECT * FROM user";
        List<User> users = new ArrayList<>();

        Connection connection = DaoConnector.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(queryFindAll)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
                users.add(mapper.extractFromResultSet(resultSet));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User update(User o) {
        return null;
    }

    @Override
    public boolean delete(Long o) {
        return false;
    }

    @Override
    public Optional<User> findById(Long id) {

        String findById = "SELECT * FROM user WHERE id = ?";
        User user = null;

        Connection connection = DaoConnector.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(findById)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = mapper.extractFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(user);
    }

    @Override
    public boolean existsByEmail(String email) {

        String findByEmail = "SELECT * FROM user WHERE email = ?;";

        Connection connection = DaoConnector.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(findByEmail)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return false;
    }

    @Override
    public Optional<User> checkUserDetails(String email) {

        String findByEmail = "SELECT * FROM user WHERE email = ?";
        Connection connection = DaoConnector.getConnection();
        User user = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(findByEmail)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = mapper.extractFromResultSet(resultSet);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return Optional.ofNullable(user);
    }

    @Override
    public User save(User user) {

        String insert = "INSERT INTO user (first_name, last_name, email, user_password, age, ipn, " +
                "personality, address, date, user_role, active) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = DaoConnector.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getAge());
            preparedStatement.setString(6, user.getIpn());
            preparedStatement.setString(7, String.valueOf(user.getPersonality()));
            preparedStatement.setString(8, user.getAddress());
            preparedStatement.setDate(9, Date.valueOf(LocalDate.now()));
            preparedStatement.setString(10, "USER");
            preparedStatement.setBoolean(11, true);

            preparedStatement.executeUpdate();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return user;
    }

    @Override
    public Map<String, Long> getStatisticDataUsersCountByRoles() {

        String statisticReportsCountQuery = "SELECT " +
                "       SUM(IF(u.user_role = 'USER', 1, 0)) AS user_count, " +
                "       SUM(IF(u.user_role = 'INSPECTOR', 1, 0)) AS inspector_count" +
                "       FROM user as u";

        Map<String, Long> data = new TreeMap<>();

        Connection connection = DaoConnector.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(statisticReportsCountQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                data.put("user_count", resultSet.getLong("user_count"));
                data.put("inspector_count", resultSet.getLong("inspector_count"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
