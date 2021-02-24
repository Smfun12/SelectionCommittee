package com.servlet.command;

import com.servlet.model.entity.Student;
import com.servlet.model.service.FacultyService;
import com.servlet.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Optional;

public class SubmitFacultyCommand implements Command {
    private FacultyService facultyService;
    private StudentService studentService;
    public SubmitFacultyCommand(StudentService studentService, FacultyService facultyService) {
        this.facultyService = facultyService;
        this.studentService = studentService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String user = (String) request.getSession().getAttribute("login");
        int facultyid = Integer.parseInt(request.getParameter("id"));
        int studentid = Integer.parseInt(request.getParameter("studentid"));
        studentService.setOneFaculty(studentid,facultyid);
        try {
            Optional<Student> student = studentService.findById(studentid);
            student.get().setInSearch(false);
            studentService.updateStudent(student.get());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user == null){
            request.setAttribute("exception","User is not logged");
            return "/WEB-INF/error.jsp";
        }
        if (user.equals("admin"))
            return "/WEB-INF/admin/adminbasis.jsp";
        return "/WEB-INF/user/userbasis.jsp";
    }
}
