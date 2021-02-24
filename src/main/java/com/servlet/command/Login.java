package com.servlet.command;

import com.servlet.model.entity.Faculty;
import com.servlet.model.entity.Student;
import com.servlet.model.entity.enums.Roles;
import com.servlet.model.service.StudentService;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Login implements Command {
    StudentService studentService;

    public Login(){
        studentService = new StudentService();
    }
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        System.out.println(name + " " + pass);
        if( name == null || name.equals("") || pass == null || pass.equals("")  ){
            return "/login.jsp";
        }
        StudentService service = new StudentService();
        Optional<Student> student;
        try {
            student = service.findByLogin(name);
        } catch (SQLException e) {
            request.setAttribute("exception", "student does not exist");
            return "/WEB-INF/error.jsp";
        }
        if (!student.isPresent()){
            request.setAttribute("exception", "student does not exist");
            return "/WEB-INF/error.jsp";
        }
        request.getSession().setAttribute("login",student.get().getLogin());
        if(CommandUtility.checkUserIsLogged(request, name)){
            request.setAttribute("exception","User is already logged");
            return "/WEB-INF/error.jsp";
        }
        if (name.equals("admin")){
            CommandUtility.setUserRole(request, Roles.ADMIN, name);
            return "/WEB-INF/admin/adminbasis.jsp";
        } else {
            CommandUtility.setUserRole(request, Roles.USER, name);
            request.setAttribute("login",name);
            List<Faculty> allFaculties = studentService.getAllFaculties(student.get().getId());
            request.setAttribute("faculties",allFaculties);
            return "/WEB-INF/user/userbasis.jsp";
        }
    }
}
