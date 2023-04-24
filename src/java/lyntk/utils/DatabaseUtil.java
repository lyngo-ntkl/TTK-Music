/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyntk.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Dell
 */
public class DatabaseUtil implements Serializable{
    public static Connection getDatabaseConnection() throws SQLException, NamingException{
        Context context = new InitialContext();
        Context envContext = (Context) context.lookup("java:comp/env");
        DataSource datasource = (DataSource) envContext.lookup("DBConnection");
        Connection connection = datasource.getConnection();
        return connection;
    }
}
