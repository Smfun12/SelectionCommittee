package com.servlet.command;

import com.servlet.model.service.FacultyService;
import com.servlet.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;

public class DeleteFacultyCommand implements Command{
    private FacultyService facultyService;

    public DeleteFacultyCommand(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Override
    public String execute(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("facultyid"));
        facultyService.deleteFaculty(id);
        return "/WEB-INF/admin/adminbasis.jsp";
    }
}
