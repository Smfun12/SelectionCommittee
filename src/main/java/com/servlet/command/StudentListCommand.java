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
        int start = Integer.parseInt(request.getParameter("currentPage"));
        int total = Integer.parseInt(request.getParameter("recordsPerPage"));
        if (start > 1){
            start--;
            start = start*total+1;
        }
        List<Student> students = studentService.getAllStudents(start,total);
        int nOfPages = students.size() / total;

        if (nOfPages % total > 0) {

            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", start);
        request.setAttribute("total", total);
        request.setAttribute("students" , students);
        return "/studentList.jsp";
    }
}
