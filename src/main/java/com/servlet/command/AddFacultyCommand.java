package com.servlet.command;

import com.servlet.model.entity.Faculty;
import com.servlet.model.service.FacultyService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class AddFacultyCommand implements Command{
    private final FacultyService facultyService;

    public AddFacultyCommand(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Override
    public String execute(HttpServletRequest request){
        Faculty faculty = new Faculty();
        faculty.setTitle(request.getParameter("title"));
        faculty.setTotalPlaces(Integer.parseInt(request.getParameter("totalPlaces")));
        faculty.setBudgetPlaces(Integer.parseInt(request.getParameter("budgetPlaces")));
        faculty.setContractPlaces(Integer.parseInt(request.getParameter("contractPlaces")));
        faculty.setFirstSubject(request.getParameter("firstSubject"));
        faculty.setSecondSubject(request.getParameter("secondSubject"));
        faculty.setThirdSubject(request.getParameter("thirdSubject"));
        try {
            facultyService.createFaculty(faculty);
        } catch (SQLException e) {
            request.setAttribute("exception","Faculty exist");
            return "/WEB-INF/error.jsp";
        }
        return "/index.jsp";
    }
}
