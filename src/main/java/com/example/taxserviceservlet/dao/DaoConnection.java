package com.example.taxserviceservlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoConnection {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            String driver = "{db.driver}";
            String dbURL = "{db.url}";
            String dbUSERNAME = "{db.username}";
            String dbPASSWORD = "{db.password}";
            System.out.println(driver + " " + dbURL);
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(dbURL, dbUSERNAME, dbPASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
