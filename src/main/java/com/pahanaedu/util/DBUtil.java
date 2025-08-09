package com.pahanaedu.util;


import java.sql.*;
public class DBUtil {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/pahanaedu?useSSL=false&serverTimezone=Asia/Colombo";
        String user = "pahana";          // or "root"
        String pass = "";  // change to your password
        return DriverManager.getConnection(url, user, pass);
    }
}
