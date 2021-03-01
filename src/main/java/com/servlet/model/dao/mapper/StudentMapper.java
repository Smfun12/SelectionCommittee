package com.servlet.model.dao.mapper;


import com.servlet.model.entity.Student;
import com.servlet.model.entity.enums.Roles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class StudentMapper implements ObjectMapper<Student> {


    @Override
    public Student extractFromResultSet(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("studentid"));
        student.setLogin(rs.getString("login"));
        student.setEmail(rs.getString("email"));
        student.setPassword(rs.getString("password"));
        student.setCity(rs.getString("city"));
        student.setDistrict(rs.getString("district"));
        student.setSchool(rs.getString("school"));
        student.setRoles( Roles.valueOf(rs.getString("role")));
        student.setInSearch(rs.getBoolean("inSearch"));
        student.setOnBudget(rs.getBoolean("onBudget"));
        return student;
    }

    @Override
    public Student makeUnique(Map<Integer, Student> cache,
                              Student student) {
        cache.putIfAbsent(student.getId(), student);
        return cache.get(student.getId());
    }
}
