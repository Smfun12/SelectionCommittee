package com.servlet.model.dao.impl;

import com.servlet.model.dao.FacultyDao;
import com.servlet.model.dao.mapper.FacultyMapper;
import com.servlet.model.dao.mapper.StudentMapper;
import com.servlet.model.entity.Faculty;
import com.servlet.model.entity.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCFacultyDao implements FacultyDao {
    private Connection connection;

    public JDBCFacultyDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Faculty entity) {

    }

    @Override
    public Faculty findById(int id) {
        return null;
    }

    @Override
    public List<Faculty> findAll() {
        Map<Integer, Student> students = new HashMap<>();
        Map<Integer, Faculty> facultyMap = new HashMap<>();

        final String query ="select * from faculties";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);

            FacultyMapper facultyMapper = new FacultyMapper();
            StudentMapper studentMapper;
            studentMapper = new StudentMapper();

            while (rs.next()) {
                Student student = studentMapper
                        .extractFromResultSet(rs);
                Faculty faculty;
                faculty = facultyMapper
                        .extractFromResultSet(rs);
                student = studentMapper
                        .makeUnique(students, student);
                faculty = facultyMapper
                        .makeUnique(facultyMap, faculty);
                student.getFaculties().add(faculty);
            }
            return new ArrayList<>(facultyMap.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Faculty entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close()  {

    }
}
