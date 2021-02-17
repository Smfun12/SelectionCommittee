package com.servlet;

import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello!");
        Connection con =
                DriverManager.
                        getConnection("jdbc:" +
                                        "mysql:" +
                                        "//localhost:3306/" +
                                        "committee",
                                "root",
                                "root");

        Statement query = con.createStatement();
        ResultSet rs = query.executeQuery("SELECT * FROM students");
        while (rs.next()) {
            System.out.println(rs.getString("login"));
        }
    }
}
