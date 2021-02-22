package com.servlet.servlets;

import com.servlet.command.*;
import com.servlet.command.Exception;
import com.servlet.model.service.FacultyService;
import com.servlet.model.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    public void init(){
        commands.put("logout", new LogOut());
        commands.put("login", new Login());
        commands.put("registration", new Registration());
        commands.put("exception" , new Exception());
        commands.put("studentList", new StudentListCommand(new StudentService()));
        commands.put("facultyList", new FacultyListCommand(new FacultyService()));
        commands.put("addStudent", new AddStudentCommand(new StudentService()));
        commands.put("showEditStudentPage", new EditStudentPageCommand(new StudentService()));
        commands.put("editStudent", new EditStudentCommand(new StudentService()));
        commands.put("deleteStudent", new DeleteStudentCommand(new StudentService()));
        commands.put("addFacultyPage", new AddFacultyPageCommand());
        commands.put("addFaculty", new AddFacultyCommand(new FacultyService()));
        commands.put("showEditFacultyPage", new EditFacultyPageCommand(new FacultyService()));
        commands.put("editFaculty", new EditFacultyCommand(new FacultyService()));
        commands.put("deleteFaculty", new DeleteFacultyCommand(new FacultyService()));
        commands.put("applyOnFaculty",new ApplyOnFacultyCommand(new StudentService(), new FacultyService()));
        System.out.println("***************************INIT***************************");
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("***************************GET***************************");
        processRequest(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("***************************POST***************************");
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println(path);
        path = path.replaceAll(".*/app/" , "");
        System.out.println(path);
        Command command = commands.getOrDefault(path ,
                (r)->"/index.jsp");
        String page = command.execute(request);
        if(page.contains("redirect:")){
            response.sendRedirect(page.replace("redirect:", "/"));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}