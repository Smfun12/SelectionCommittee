package com.servlet.command;

import com.servlet.model.entity.Student;
import com.servlet.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;

public class EditStudentCommand implements Command{
    private StudentService studentService;

    public EditStudentCommand(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public String execute(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = new Student();
        student.setId(id);
        student.setLogin(request.getParameter("login"));
        student.setEmail(request.getParameter("email"));
        student.setPassword(request.getParameter("password"));
        student.setCity(request.getParameter("city"));
        student.setDistrict(request.getParameter("district"));
        student.setSchool(request.getParameter("school"));
        studentService.updateStudent(student);
        return "/studentList.jsp";
    }
}
