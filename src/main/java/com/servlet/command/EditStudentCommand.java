package com.servlet.command;

import com.servlet.model.entity.Student;
import com.servlet.model.entity.enums.Roles;
import com.servlet.model.service.StudentService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class EditStudentCommand implements Command {
    private final StudentService studentService;

    static final Logger LOGGER = Logger.getLogger(EditStudentCommand.class);

    public EditStudentCommand(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = new Student();
        student.setId(id);
        student.setLogin(request.getParameter("login"));
        student.setEmail(request.getParameter("email"));
        student.setPassword(request.getParameter("password"));
        student.setCity(request.getParameter("city"));
        student.setDistrict(request.getParameter("district"));
        student.setSchool(request.getParameter("school"));
        student.setRoles(Roles.USER);
        try {
            studentService.updateStudent(student);
        } catch (SQLException e) {
            request.setAttribute("exception","Student exist");
            return "/WEB-INF/error.jsp";
        }
        LOGGER.info("edit student successfully");
        return "/WEB-INF/admin/adminbasis.jsp";
    }
}
