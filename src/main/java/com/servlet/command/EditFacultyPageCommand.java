package com.servlet.command;

import com.servlet.model.entity.Faculty;
import com.servlet.model.entity.Student;
import com.servlet.model.service.FacultyService;
import com.servlet.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;

public class EditFacultyPageCommand implements Command{
    private FacultyService facultyService;

    public EditFacultyPageCommand(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Override
    public String execute(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        Faculty faculty= facultyService.findById(id);
        request.setAttribute("id",faculty.getFacultyid());
        request.setAttribute("title",faculty.getTitle());
        request.setAttribute("totalPlaces",faculty.getTotalPlaces());
        request.setAttribute("budgetPlaces",faculty.getBudgetPlaces());
        request.setAttribute("contractPlaces",faculty.getContractPlaces());
        request.setAttribute("firstSubject",faculty.getFirstSubject());
        request.setAttribute("secondSubject",faculty.getSecondSubject());
        request.setAttribute("thirdSubject",faculty.getThirdSubject());
        return "/facultyEdit.jsp";
    }
}
