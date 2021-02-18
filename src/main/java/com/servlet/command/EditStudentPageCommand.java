package com.servlet.command;

import com.servlet.model.entity.Student;
import com.servlet.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;

public class EditStudentPageCommand implements Command{
    private StudentService studentService;

    public EditStudentPageCommand(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public String execute(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("id",student.getId());
        request.setAttribute("login",student.getLogin());
        request.setAttribute("email",student.getEmail());
        request.setAttribute("password",student.getPassword());
        request.setAttribute("city",student.getCity());
        request.setAttribute("district",student.getDistrict());
        request.setAttribute("school",student.getSchool());
        return "/studentEdit.jsp";
    }
}
