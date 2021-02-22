package com.servlet.model.dao;

import com.servlet.model.entity.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericDao<T> extends AutoCloseable {
    void create(T entity);
    T findById(int id);
    List<T> findAll(int start, int total);
    List<T> findAll();
    void update(T entity) throws SQLException;
    void delete(int id);
    void close();

    Optional<Student> findByLogin(String login);
}
