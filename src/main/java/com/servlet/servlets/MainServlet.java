package com.servlet.servlets;

import com.servlet.command.*;
import com.servlet.model.service.FacultyService;
import com.servlet.model.service.StudentService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {
    private final Map<String, Command> commands = new HashMap<>();
    private final Map<String, PdfCommand> pdfCommandMap = new HashMap<>();

    static final Logger LOGGER = Logger.getLogger(MainServlet.class);

    public void init() {
        commands.put("logout", new LogOut());
        commands.put("login", new Login());
        commands.put("registration", new Registration());
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
        commands.put("applyOnFaculty", new ApplyOnFacultyPageCommand(new StudentService(), new FacultyService()));
        commands.put("applyStudentOnFaculty", new ApplyOnFacultyCommand(new StudentService(), new FacultyService()));
        commands.put("showStudentsOnFaculty", new StudentsOnFacultyCommand(new FacultyService()));
        commands.put("submitFaculty", new SubmitFacultyCommand(new StudentService()));
        commands.put("enableStudent", new EnableStudentCommand(new StudentService()));
        commands.put("disableStudent", new DisableStudentCommand(new StudentService()));
        commands.put("userProfile", new UserProfilePageCommand(new StudentService()));
        commands.put("home", new ReturnHomeCommand(new StudentService()));
        commands.put("finalize", new FinalizeResultCommand(new StudentService(), new FacultyService()));
        pdfCommandMap.put("exportStudentsToPdf", new ExportStudentsToPdfCommand(new StudentService()));
        pdfCommandMap.put("exportFacultiesToPdf", new ExportFacultiesToPdfCommand(new FacultyService()));
        LOGGER.info("***************************INIT***************************");
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        LOGGER.info("***************************GET***************************");
        processRequest(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        LOGGER.info("***************************POST***************************");
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        LOGGER.info(path);
        path = path.replaceAll(".*/app/", "");
        LOGGER.info(path);
        if (path.contains("export")) {
            PdfCommand pdfCommand = pdfCommandMap.getOrDefault(path, (req, res) -> "/index.jsp");
            String page1 = pdfCommand.execute(request, response);
            if (page1.contains("redirect:")) {
                response.sendRedirect(page1.replace("redirect:", "/"));
            } else {
                request.getRequestDispatcher(page1).forward(request, response);
            }
        } else {
            Command command = commands.getOrDefault(path,
                    (r) -> "/index.jsp");
            String page = command.execute(request);
            if (page.contains("redirect:")) {
                response.sendRedirect(page.replace("redirect:", "/"));
            } else {
                request.getRequestDispatcher(page).forward(request, response);
            }
        }
    }
}