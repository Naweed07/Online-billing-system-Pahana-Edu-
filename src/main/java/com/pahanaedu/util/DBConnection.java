package com.pahanaedu.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver Registered!");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/pahanaedu?useSSL=false&serverTimezone=Asia/Colombo",
                "root",
                ""  // empty password if none set
            );
            System.out.println("DB Connection successful: " + conn);
            return conn;
        } catch (Exception e) {
            System.err.println("DB Connection failed!");
            e.printStackTrace(); // IMPORTANT: Check console for detailed error
            return null;
        }
    }
}
