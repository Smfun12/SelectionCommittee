package com.servlet.command;

import com.servlet.model.entity.Faculty;
import com.servlet.model.entity.Student;
import com.servlet.model.service.FacultyService;
import com.servlet.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ApplyOnFacultyCommand implements Command{

    StudentService studentService;
    FacultyService facultyService;
    public ApplyOnFacultyCommand(StudentService studentService, FacultyService facultyService){
        this.studentService = studentService;
        this.facultyService = facultyService;
    }
    @Override
    public String execute(HttpServletRequest request) {
        int facultyId = Integer.parseInt(request.getParameter("facultyid"));
        String user = (String) request.getSession().getAttribute("login");
        Optional<Student> student;
        try {
            Optional<Faculty> faculty = facultyService.findById(facultyId);
            student = studentService.findByLogin(user);
            student.get().getFaculties().add(faculty.get());
            studentService.addFaculty(student.get(),faculty.get());
        } catch (SQLException e) {
            request.setAttribute("exception", "student does not exist");
            return "/WEB-INF/error.jsp";
        }
        if (user.equals("user")){
            List<Faculty> allFaculties = studentService.getAllFaculties(student.get().getId());
            request.setAttribute("faculties",allFaculties);
            return "/WEB-INF/user/userbasis.jsp";
        }
        return "/WEB-INF/admin/adminbasis.jsp";
    }
}
