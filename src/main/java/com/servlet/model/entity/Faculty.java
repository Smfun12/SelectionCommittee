package com.servlet.model.entity;


import java.util.HashSet;
import java.util.Set;

public class Faculty {

    private int facultyid;

    private String title;


    private int budgetPlaces;

    private int contractPlaces;

    private int totalPlaces;

    private String firstSubject;

    private String secondSubject;

    public String getFirstSubject() {
        return firstSubject;
    }

    public void setFirstSubject(String firstSubject) {
        this.firstSubject = firstSubject;
    }

    public String getSecondSubject() {
        return secondSubject;
    }

    public void setSecondSubject(String secondSubject) {
        this.secondSubject = secondSubject;
    }

    public String getThirdSubject() {
        return thirdSubject;
    }

    public void setThirdSubject(String thirdSubject) {
        this.thirdSubject = thirdSubject;
    }

    private String thirdSubject;

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    private Set<Student> students = new HashSet<>();

    public Faculty(String title, int totalPlaces,
                   int budgetPlaces, int contractPlaces,String firstSubject,
                   String secondSubject, String thirdSubject) {
        this.title = title;
        this.totalPlaces = totalPlaces;
        this.budgetPlaces = budgetPlaces;
        this.contractPlaces = contractPlaces;
        this.firstSubject = firstSubject;
        this.secondSubject = secondSubject;
        this.thirdSubject = thirdSubject;
    }

    public Faculty() {

    }

    public int getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(int faculty_id) {
        this.facultyid = faculty_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalPlaces() {
        return totalPlaces;
    }

    public void setTotalPlaces(int totalPlaces) {
        this.totalPlaces = totalPlaces;
    }

    public int getBudgetPlaces() {
        return budgetPlaces;
    }

    public void setBudgetPlaces(int budgetPlaces) {
        this.budgetPlaces = budgetPlaces;
    }

    public int getContractPlaces() {
        return contractPlaces;
    }

    public void setContractPlaces(int contractPlaces) {
        this.contractPlaces = contractPlaces;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyid=" + facultyid +
                ", title='" + title + '\'' +
                ", budgetPlaces=" + budgetPlaces +
                ", contractPlaces=" + contractPlaces +
                ", totalPlaces=" + totalPlaces +
                ", firstSubject='" + firstSubject + '\'' +
                ", secondSubject='" + secondSubject + '\'' +
                ", thirdSubject='" + thirdSubject + '\'' +
                ", students=" + students +
                '}';
    }
}
