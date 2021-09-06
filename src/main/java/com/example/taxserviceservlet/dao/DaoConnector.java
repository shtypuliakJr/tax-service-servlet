package com.example.taxserviceservlet.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoConnector {

    private static Connection connection = null;

    private static final String datasourceDriver = "com.mysql.cj.jdbc.Driver";
    private static final String datasourceUrl = "jdbc:mysql://localhost:3306/tax_test";
    private static final String datasourceUsername = "root";
    private static final String datasourcePassword = "password";

    public static Connection getConnection() {

        if (connection == null) {
            synchronized (DaoConnector.class) {
                try {
                    Class.forName(datasourceDriver).getDeclaredConstructor().newInstance();
                    connection = DriverManager.getConnection(datasourceUrl, datasourceUsername, datasourcePassword);
                } catch (ClassNotFoundException | SQLException | NoSuchMethodException |
                        IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null)
                connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
