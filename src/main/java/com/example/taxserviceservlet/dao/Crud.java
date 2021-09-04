package com.example.taxserviceservlet.dao;

import com.example.taxserviceservlet.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Crud<T, ID> {

    Optional<T> findById(ID id);
    List<T> findAll();
    T save(T o);
    T update(T o);
    boolean delete(ID o);

}
