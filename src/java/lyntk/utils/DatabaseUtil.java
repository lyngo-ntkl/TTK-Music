/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyntk.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class DatabaseUtil {
    public static Connection getDatabaseConnection() throws ClassNotFoundException, SQLException{
        Connection connection = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TTK_music;encrypt=true;trustServerCertificate=true;";
        connection = DriverManager.getConnection(url, "sa", "12345");
        return connection;
    }
}
