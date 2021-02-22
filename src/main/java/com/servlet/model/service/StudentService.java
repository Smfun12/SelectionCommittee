package com.servlet.model.service;


import com.servlet.model.dao.DaoFactory;
import com.servlet.model.dao.StudentDao;
import com.servlet.model.entity.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class StudentService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Student> getAllStudents(){
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.findAll();
        }
    }

    public List<Student> getAllStudents(int start, int total){
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.findAll(start,total);
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

    public void updateStudent(Student student) throws SQLException {
        try (StudentDao dao = daoFactory.createStudentDao()) {
            dao.update(student);
        }
    }

    public void deleteStudent(int id) {
        try (StudentDao dao = daoFactory.createStudentDao()) {
            dao.delete(id);
        }
    }

    public Optional<Student> findByLogin(String login) {
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.findByLogin(login);
        }
    }
}
