package utilities.impl;

import java.sql.Connection;
import java.sql.DriverManager;

import utilities.DbConnection;

public class DbConnectionImpl implements DbConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/team_registration";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Argha@2021";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    @Override
    public Connection getConnection(Connection connection) {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
           
        }
        return connection;
    }

}
