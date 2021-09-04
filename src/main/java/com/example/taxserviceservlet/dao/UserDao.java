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

public class UserDao implements Crud<User, Long> {

    @Override
    public Optional<User> findById(Long id) {

        String findById = "SELECT * FROM user WHERE id = ?";
        Connection connection = DaoConnection.getConnection();
        User user = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(findById)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = UserMapper.setUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    public boolean existsByEmail(String email) {

        String findByEmail = "SELECT * FROM user WHERE email = ?;";
        Connection connection = DaoConnection.getConnection();

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

    public Optional<User> checkUserDetails(String email) {

        String findByEmail = "SELECT * FROM user WHERE email = ?;";
        Connection connection = DaoConnection.getConnection();
        User user = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(findByEmail)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = UserMapper.setUser(resultSet);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() throws SQLException {
        return null;
    }

    @Override
    public User save(User user) throws SQLException {
        Connection connection = DaoConnection.getConnection();
        String insert = "INSERT INTO user (first_name, last_name, email, user_password, age, ipn, " +
                "personality, address, date, user_role, active) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
        return null;
    }

    @Override
    public User update(User o) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(User o) throws SQLException {
        return false;
    }

    public Map<String, Long> getStatisticDataUsersCountByRoles() {

        String statisticReportsCountQuery = "SELECT " +
                "       SUM(IF(u.user_role = 'USER', 1, 0)) AS user_count, " +
                "       SUM(IF(u.user_role = 'INSPECTOR', 1, 0)) AS inspector_count" +
                "       FROM user as u";

        Connection connection = DaoConnection.getConnection();

        Map<String, Long> data = new TreeMap<>();
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
