package com.servlet.model.service;


import com.servlet.model.dao.DaoFactory;
import com.servlet.model.dao.FacultyDao;
import com.servlet.model.dao.StudentDao;
import com.servlet.model.entity.Faculty;
import com.servlet.model.entity.Student;

import java.util.List;

public class FacultyService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Faculty> getAllFaculties(){
        try (FacultyDao dao = daoFactory.createFacultyDao()) {
            return dao.findAll();
        }
    }
}
