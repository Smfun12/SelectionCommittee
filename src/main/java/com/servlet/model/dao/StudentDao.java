package com.servlet.model.dao;


import com.servlet.model.entity.Faculty;
import com.servlet.model.entity.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface StudentDao extends GenericDao<Student> {
    void addFaculty(Student student, Faculty faculty);
    List<Faculty> getAllFaculties(int id);
    Optional<Student> findByLogin(String login) throws SQLException;


    void setOneFaculty(int studentid, int facultyid);
}
