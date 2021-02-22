package com.servlet.model.service;


import com.servlet.model.dao.DaoFactory;
import com.servlet.model.dao.FacultyDao;
import com.servlet.model.dao.StudentDao;
import com.servlet.model.entity.Faculty;
import com.servlet.model.entity.Student;

import java.sql.SQLException;
import java.util.List;

public class FacultyService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Faculty> getAllFaculties(int start, int total){
        try (FacultyDao dao = daoFactory.createFacultyDao()) {
            return dao.findAll(start, total);
        }
    }

    public void createFaculty(Faculty faculty) {
        try (FacultyDao dao = daoFactory.createFacultyDao()) {
            dao.create(faculty);
        }
    }

    public Faculty findById(int id){
        try (FacultyDao dao = daoFactory.createFacultyDao()) {
            return dao.findById(id);
        }
    }

    public void updateFaculty(Faculty faculty) throws SQLException {
        try (FacultyDao dao = daoFactory.createFacultyDao()) {
            dao.update(faculty);
        }
    }

    public void deleteFaculty(int id) {
        try (FacultyDao dao = daoFactory.createFacultyDao()) {
            dao.delete(id);
        }
    }


}
