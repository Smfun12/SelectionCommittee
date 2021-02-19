package com.servlet.command;

import com.servlet.model.entity.Faculty;
import com.servlet.model.entity.Student;
import com.servlet.model.service.FacultyService;
import com.servlet.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;

public class AddFacultyCommand implements Command{
    private FacultyService facultyService;

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
        facultyService.createFaculty(faculty);
        return "/index.jsp";
    }
}
