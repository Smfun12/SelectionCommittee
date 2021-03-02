package com.servlet.command;

import com.servlet.model.entity.Faculty;
import com.servlet.model.entity.Student;
import com.servlet.model.service.FacultyService;
import com.servlet.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class FinalizeResultCommand implements Command {
    private final StudentService studentService;
    private final FacultyService facultyService;

    public FinalizeResultCommand(StudentService studentService, FacultyService facultyService) {
        this.facultyService = facultyService;
        this.studentService = studentService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<Faculty> facultyList = facultyService.getFaculties();
        for (Faculty faculty : facultyList) {
            int budgetPlaces = faculty.getBudgetPlaces();

            List<Student> studentList = facultyService.getAllStudents(faculty.getFacultyid());
            Collections.sort(studentList);
            for (Student student : studentList) {
                student.setOnBudget(budgetPlaces-- > 0);
                studentService.setOneFaculty(student.getId(),faculty.getFacultyid());
                try {
                    studentService.updateStudent(student);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return "/WEB-INF/admin/adminbasis.jsp";
    }
}
