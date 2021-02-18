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
    public String execute(HttpServletRequest request) {
        studentService.createStudent(new Student());
        return "/index.jsp";
    }
}
