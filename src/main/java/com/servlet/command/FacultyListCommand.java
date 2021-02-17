package com.servlet.command;

import com.servlet.model.entity.Faculty;
import com.servlet.model.entity.Student;
import com.servlet.model.service.FacultyService;
import com.servlet.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FacultyListCommand implements Command {
    private FacultyService facultyService;

    public FacultyListCommand(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<Faculty> faculties = facultyService.getAllFaculties();
        request.setAttribute("faculties" , faculties);
        return "/facultyList.jsp";
    }
}
