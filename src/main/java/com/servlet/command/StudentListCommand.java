package com.servlet.command;

import com.servlet.model.entity.Student;
import com.servlet.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StudentListCommand implements Command {
    private StudentService studentService;

    public StudentListCommand(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<Student> students = studentService.getAllStudents();
        request.setAttribute("students" , students);
        return "/studentList.jsp";
    }
}