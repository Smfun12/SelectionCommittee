package com.servlet.model.service;

import com.servlet.model.dao.impl.JDBCDaoFactory;
import com.servlet.model.dao.impl.JDBCFacultyDao;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.mockito.Mockito.when;

public class FacultyServiceTest {

    @Mock
    JDBCFacultyDao facultyDao = (JDBCFacultyDao) new JDBCDaoFactory().createFacultyDao();

    @Test
    public void testGetAllFaculties() {

    }

    @Test
    public void testCreateFaculty() {
    }

    @Test
    public void testFindById() throws SQLException {
        MockitoAnnotations.initMocks(this);
        FacultyService facultyService = Mockito.mock(FacultyService.class);
        Mockito.verify(facultyService);
        when(facultyService.findById(1).get().getFacultyid()).thenReturn(1);

    }

    @Test
    public void testUpdateFaculty() {
    }

    @Test
    public void testDeleteFaculty() {
    }

    @Test
    public void testGetAllStudents() {
    }
}