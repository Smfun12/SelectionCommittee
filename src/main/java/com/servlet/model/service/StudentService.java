package com.servlet.model.service;


import com.servlet.model.dao.DaoFactory;
import com.servlet.model.dao.StudentDao;
import com.servlet.model.entity.Student;

import java.util.List;

public class StudentService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Student> getAllStudents(){
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.findAll();
        }
    }
    public void createStudent(Student student){
        try (StudentDao dao = daoFactory.createStudentDao()) {
            dao.create(student);
        }
    }

    public Student findById(int id){
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.findById(id);
        }
    }

    public void updateStudent(Student student) {
        try (StudentDao dao = daoFactory.createStudentDao()) {
            dao.update(student);
        }
    }
}
