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
import java.util.Optional;

public class UserDao implements Crud<User, Long> {


    @Override
    public Optional<User> findById(Long id) {
        String findById = "SELECT * FROM user WHERE id = ?";
        Connection connection = DaoConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(findById)) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
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
            while (resultSet.next()) {
                user = new User.Builder()
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
        try (PreparedStatement preparedStatement=connection.prepareStatement(insert)) {
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
}
