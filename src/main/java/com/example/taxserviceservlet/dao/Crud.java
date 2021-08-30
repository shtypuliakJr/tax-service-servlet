package com.example.taxserviceservlet.dao;

import com.example.taxserviceservlet.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Crud<T, ID> {

    Optional<T> findById(ID id) throws SQLException;
    List<T> findAll() throws SQLException;
    User save(T o) throws SQLException;
    User update(T o) throws SQLException;
    boolean delete(T o) throws SQLException;

}
