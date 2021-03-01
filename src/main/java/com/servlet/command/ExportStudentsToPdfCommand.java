package com.servlet.command;

import com.servlet.model.entity.Student;
import com.servlet.model.service.StudentService;
import com.servlet.utilities.StudentPDFExporter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExportStudentsToPdfCommand implements PdfCommand {

    StudentService studentService;

    public ExportStudentsToPdfCommand(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=students_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Student> studentList = studentService.getStudents();

        StudentPDFExporter exporter = new StudentPDFExporter(studentList, studentService);
        try {
            exporter.export(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/index.jsp";
    }
}
