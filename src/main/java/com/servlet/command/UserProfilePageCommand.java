package com.servlet.command;

import com.servlet.model.entity.Faculty;
import com.servlet.model.entity.Student;
import com.servlet.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserProfilePageCommand implements Command {
    private final StudentService studentService;

    public UserProfilePageCommand(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int studentId = Integer.parseInt(request.getParameter("id"));
        try {
            Optional<Student> student = studentService.findById(studentId);
            request.setAttribute("login", student.get().getLogin());
            request.setAttribute("email", student.get().getEmail());
            request.setAttribute("firstGrade", student.get().getFirstGrade());
            request.setAttribute("secondGrade", student.get().getSecondGrade());
            request.setAttribute("thirdGrade", student.get().getThirdGrade());
        } catch (SQLException e) {
            return "/WEB-INF/error.jsp";
        }
        List<Faculty> allFaculties = studentService.getAllFaculties(studentId);
        if (request.getSession().getAttribute("login").equals("admin")) {
            request.setAttribute("isAdmin", true);
        }
        request.setAttribute("faculties", allFaculties);
        return "/userProfile.jsp";
    }
}
