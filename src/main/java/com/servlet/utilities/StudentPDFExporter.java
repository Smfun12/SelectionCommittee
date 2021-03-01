package com.servlet.utilities;


import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.servlet.model.entity.Faculty;
import com.servlet.model.entity.Student;
import com.servlet.model.service.StudentService;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for exporting students to pdf format
 */
public class StudentPDFExporter {
    private final List<Student> studentList;
    private final StudentService studentService;

    public StudentPDFExporter(List<Student> studentList, StudentService studentServices) {
        this.studentList = studentList;
        this.studentService = studentServices;
    }

    /**
     * Add header for table
     *
     * @param table - current table
     */
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Student ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("E-mail", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Login", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Roles", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Faculties", font));
        table.addCell(cell);
    }

    /**
     * Write object fields to cells
     *
     * @param table - current table
     */
    private void writeTableData(PdfPTable table) {
        for (Student student : studentList) {
            PdfPCell cell = new PdfPCell();
            List<String> faculties = new ArrayList<>();
            for (Faculty faculty : studentService.getAllFaculties(student.getId())) {
                faculties.add(faculty.getTitle());
            }
            if (student.isOnBudget()) {
                cell.setBackgroundColor(Color.green);
                cell.setPhrase(new Phrase(String.valueOf(student.getId())));
                table.addCell(cell);
                cell.setBackgroundColor(Color.green);
                cell.setPhrase(new Phrase(student.getLogin()));
                table.addCell(cell);
                cell.setBackgroundColor(Color.green);
                cell.setPhrase(new Phrase(student.getEmail()));
                table.addCell(cell);
                cell.setBackgroundColor(Color.green);
                cell.setPhrase(new Phrase(student.getRoles().toString()));
                table.addCell(cell);
                cell.setBackgroundColor(Color.green);
            } else {
                cell.setBackgroundColor(Color.red);
                cell.setPhrase(new Phrase(String.valueOf(student.getId())));
                table.addCell(cell);
                cell.setBackgroundColor(Color.red);
                cell.setPhrase(new Phrase(student.getLogin()));
                table.addCell(cell);
                cell.setBackgroundColor(Color.red);
                cell.setPhrase(new Phrase(student.getEmail()));
                table.addCell(cell);
                cell.setBackgroundColor(Color.red);
                cell.setPhrase(new Phrase(student.getRoles().toString()));
                table.addCell(cell);
                cell.setBackgroundColor(Color.red);
            }
            cell.setPhrase(new Phrase(faculties.toString()));
            table.addCell(cell);

        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        try (Document document = new Document(PageSize.A4)) {
            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            font.setSize(18);
            font.setColor(Color.BLUE);

            Paragraph p = new Paragraph("List of Students", font);
            p.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(p);

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100f);
            table.setWidths(new float[]{1.5f, 3.5f, 3.0f, 1.5f, 3.0f});
            table.setSpacingBefore(10);

            writeTableHeader(table);
            writeTableData(table);

            document.add(table);
        }
    }
}
