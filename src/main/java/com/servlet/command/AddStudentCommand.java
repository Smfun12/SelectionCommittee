package com.servlet.command;

import com.servlet.model.entity.Student;
import com.servlet.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddStudentCommand implements Command{
    private StudentService studentService;

    public AddStudentCommand(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public String execute(HttpServletRequest request){
        Student student = new Student();
        student.setLogin(request.getParameter("login"));
        student.setEmail(request.getParameter("email"));
        student.setPassword(request.getParameter("password"));
        student.setCity(request.getParameter("city"));
        student.setDistrict(request.getParameter("district"));
        student.setSchool(request.getParameter("school"));
        studentService.createStudent(student);
        return "/index.jsp";
    }
}
