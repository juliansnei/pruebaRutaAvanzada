package org.riwi.persistence.configDB;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class MySQLConfig {
    private static Connection connect = null;

    public static Connection connectDatabase(){
        String URL = "jdbc:mysql://localhost:3306/RiwiAcademyDB";
        String user = "root";
        String password = "Rlwl2023.";

        try {
            connect = DriverManager.getConnection(URL,user,password);
            System.out.println("Connection established");
        } catch (SQLException error){
            throw new RuntimeException(error.getMessage());
        }

        return connect;
    }

    public static void closeConnection(){
        try {
            connect.close();
            System.out.println("Connection closed");
        } catch (SQLException error){
            throw new RuntimeException(error.getMessage());
        }
    }
}
