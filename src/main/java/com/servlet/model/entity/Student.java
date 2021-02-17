package com.servlet.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private int id;

    private String login;

    private String email;


    private String password;

    private String city;

    private String district;

    private String school;

    List<Faculty> faculties = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getSchool() {
        return school;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public Student(){

    }
    public Student(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public Student(String login, String email, String password, String city, String district, String school) {

        this.login = login;
        this.email = email;
        this.password = password;
        this.city = city;
        this.district = district;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
