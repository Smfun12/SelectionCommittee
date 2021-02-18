package com.servlet.model.dao.impl;


import com.servlet.model.dao.StudentDao;
import com.servlet.model.dao.mapper.FacultyMapper;
import com.servlet.model.dao.mapper.StudentMapper;
import com.servlet.model.entity.Faculty;
import com.servlet.model.entity.Student;

import java.sql.*;
import java.util.*;

public class JDBCStudentDao implements StudentDao {
    private Connection connection;


    public JDBCStudentDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Student entity) {
        final String query ="INSERT INTO students (login,email,password,city,district,school) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,entity.getLogin());
            statement.setString(2,entity.getEmail());
            statement.setString(3,entity.getPassword());
            statement.setString(4,entity.getCity());
            statement.setString(5,entity.getDistrict());
            statement.setString(6,entity.getSchool());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Student findById(int id) {
        final String query ="select * from students where studentid=?";
        StudentMapper studentMapper = new StudentMapper();

        try {
            Student student = null;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
            student = studentMapper.extractFromResultSet(resultSet);
            }
            if (student != null)
                return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        Map<Integer, Student> students = new HashMap<>();
        Map<Integer, Faculty> facultyMap = new HashMap<>();

        final String query ="select * from students";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);

            FacultyMapper facultyMapper = new FacultyMapper();
            StudentMapper studentMapper = new StudentMapper();

            while (rs.next()) {
                Student student = studentMapper
                        .extractFromResultSet(rs);
                Faculty faculty = facultyMapper
                        .extractFromResultSet(rs);
                student = studentMapper
                        .makeUnique(students, student);
                faculty = facultyMapper
                        .makeUnique(facultyMap, faculty);
                student.getFaculties().add(faculty);
            }
            return new ArrayList<>(students.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    @Override
    public void update(Student entity) {
        final String query ="UPDATE students set login=?,email=?,password=?,city=?" +
                ",district=?,school=? where studentid=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,entity.getLogin());
            statement.setString(2,entity.getEmail());
            statement.setString(3,entity.getPassword());
            statement.setString(4,entity.getCity());
            statement.setString(5,entity.getDistrict());
            statement.setString(6,entity.getSchool());
            statement.setInt(7,entity.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close()  {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
