package com.servlet.model.dao.impl;

import com.servlet.model.dao.FacultyDao;
import com.servlet.model.dao.mapper.FacultyMapper;
import com.servlet.model.entity.Faculty;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCFacultyDao implements FacultyDao {
    private Connection connection;

    JDBCFacultyDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Faculty entity) {
        final String query =
                "INSERT INTO faculties (title, totalPlaces,budgetPlaces," +
                        "contractPlaces,firstSubject,secondSubject,thirdSubject) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,entity.getTitle());
            statement.setInt(2,entity.getTotalPlaces());
            statement.setInt(3,entity.getBudgetPlaces());
            statement.setInt(4,entity.getContractPlaces());
            statement.setString(5,entity.getFirstSubject());
            statement.setString(6,entity.getSecondSubject());
            statement.setString(7,entity.getThirdSubject());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Faculty findById(int id) {
        final String query ="select * from faculties where facultyid=?";
        FacultyMapper facultyMapper = new FacultyMapper();

        try {
            Faculty faculty = null;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                faculty = facultyMapper.extractFromResultSet(resultSet);
            }
            if (faculty != null)
                return faculty;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Faculty> findAll(int currentPage, int recordsPerPage) {
        Map<Integer, Faculty> facultyMap = new HashMap<>();

        int start = currentPage * recordsPerPage - recordsPerPage;


        final String query ="select * from faculties LIMIT " + start + "," + recordsPerPage;
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);

            FacultyMapper facultyMapper = new FacultyMapper();

            while (rs.next()) {
                Faculty faculty = facultyMapper
                        .extractFromResultSet(rs);
                facultyMapper.makeUnique(facultyMap, faculty);
            }
            return new ArrayList<>(facultyMap.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Faculty entity) {
        final String query ="UPDATE faculties set title=?,totalPlaces=?,budgetPlaces=?," +
                "contractPlaces=?" +
                ",firstSubject=?,secondSubject=?,thirdSubject=? where facultyid=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,entity.getTitle());
            statement.setInt(2,entity.getTotalPlaces());
            statement.setInt(3,entity.getBudgetPlaces());
            statement.setInt(4,entity.getContractPlaces());
            statement.setString(5,entity.getFirstSubject());
            statement.setString(6,entity.getSecondSubject());
            statement.setString(7,entity.getThirdSubject());
            statement.setInt(8,entity.getFacultyid());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        final String query ="DELETE FROM faculties WHERE facultyid=?";
        deleteEntity(id, query, connection);
    }

    static void deleteEntity(int id, String query, Connection connection) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void close()  {

    }
}
