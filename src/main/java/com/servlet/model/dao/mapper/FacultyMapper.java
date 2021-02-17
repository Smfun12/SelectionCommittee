package com.servlet.model.dao.mapper;

import com.servlet.model.entity.Faculty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class FacultyMapper implements ObjectMapper<Faculty> {

    @Override
    public Faculty extractFromResultSet(ResultSet rs) throws SQLException {
        Faculty faculty = new Faculty();
        faculty.setFacultyid(rs.getInt("facultyid"));
//        faculty.setTitle(rs.getString("title"));
        return faculty;
    }

    public Faculty makeUnique(Map<Integer, Faculty> cache,
                              Faculty faculty) {
        cache.putIfAbsent(faculty.getFacultyid(), faculty);
        return cache.get(faculty.getFacultyid());
    }
}
