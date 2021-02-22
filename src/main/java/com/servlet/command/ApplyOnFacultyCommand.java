package com.servlet.command;

import com.servlet.model.service.FacultyService;
import com.servlet.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;

public class ApplyOnFacultyCommand implements Command{

    StudentService studentService;
    FacultyService facultyService;
    public ApplyOnFacultyCommand(StudentService studentService, FacultyService facultyService){
        this.studentService = studentService;
        this.facultyService = facultyService;
    }
    @Override
    public String execute(HttpServletRequest request) {
        int facultyId = (int) request.getAttribute("facultyid");
        return "/applyOnFaculty.jsp";
    }
}
