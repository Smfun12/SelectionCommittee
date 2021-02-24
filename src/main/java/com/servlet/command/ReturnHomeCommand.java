package com.servlet.command;

import com.servlet.model.entity.Faculty;
import com.servlet.model.entity.Student;
import com.servlet.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ReturnHomeCommand implements Command {
    StudentService studentService;
    public ReturnHomeCommand(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String user = (String) request.getSession().getAttribute("login");
        if (user == null){
            request.setAttribute("exception","User is not logged");
            return "/WEB-INF/error.jsp";
        }
        if (user.equals("admin"))
            return "/WEB-INF/admin/adminbasis.jsp";
        Optional<Student> student;
        try {
            student = studentService.findByLogin(user);
        } catch (SQLException e) {
            request.setAttribute("exception", "student does not exist");
            return "/WEB-INF/error.jsp";
        }
        List<Faculty> allFaculties = studentService.getAllFaculties(student.get().getId());
        request.setAttribute("faculties",allFaculties);
        return "/WEB-INF/user/userbasis.jsp";
    }
}
