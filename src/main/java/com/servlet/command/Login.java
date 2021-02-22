package com.servlet.command;

import com.servlet.model.entity.Student;
import com.servlet.model.entity.enums.Roles;
import com.servlet.model.service.StudentService;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public class Login implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        System.out.println(name + " " + pass);
        if( name == null || name.equals("") || pass == null || pass.equals("")  ){
            return "/login.jsp";
        }
        StudentService service = new StudentService();
        Optional<Student> student = service.findByLogin(name);
        if (!student.isPresent()){
            request.setAttribute("exception", "student does not exist");
            return "/WEB-INF/error.jsp";
        }
        if(CommandUtility.checkUserIsLogged(request, name)){
            return "/WEB-INF/error.jsp";
        }
        if (name.equals("Admin")){
            CommandUtility.setUserRole(request, Roles.ADMIN, name);
            return "/WEB-INF/admin/adminbasis.jsp";
        } else if(name.equals("User")) {
            CommandUtility.setUserRole(request, Roles.USER, name);
            return "redirect:/WEB-INF/user/userbasis.jsp";
        } else {
            CommandUtility.setUserRole(request, Roles.UNKNOWN, name);
            return "/login.jsp";
        }
    }
}
