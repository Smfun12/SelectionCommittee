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
        int start = Integer.parseInt(request.getParameter("currentPage"));
        int total = Integer.parseInt(request.getParameter("recordsPerPage"));
        String sortBy = request.getParameter("sortBy");
        String order = request.getParameter("order");
        List<Faculty> faculties = facultyService.getAllFaculties(start,total,sortBy,order);

        int nOfPages = faculties.size() / total;

        if (nOfPages % total > 0) {

            nOfPages++;
        }
        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", start);
        request.setAttribute("total", total);
        request.setAttribute("faculties" , faculties);
        request.setAttribute("sortBy" , sortBy);
        request.setAttribute("order" , order);
        return "/facultyList.jsp";
    }
}
