package com.servlet.command;

import com.servlet.model.entity.Faculty;
import com.servlet.model.service.FacultyService;
import com.servlet.utilities.FacultyPDFExporter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExportFacultiesToPdfCommand implements PdfCommand {

    FacultyService facultyService;

    public ExportFacultiesToPdfCommand(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=students_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Faculty> faculties = facultyService.getFaculties();
        FacultyPDFExporter exporter = new FacultyPDFExporter(faculties, facultyService);
        try {
            exporter.export(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/index.jsp";
    }
}
