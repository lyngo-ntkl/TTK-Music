/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyntk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lyntk.dao.AccountDao;
import lyntk.models.Account;
import lyntk.utils.DatabaseUtil;

/**
 *
 * @author Dell
 */
public class AccountDaoImpl implements AccountDao {
    private static final String FIND_ACCOUNT_BY_EMAIL_AND_PASSWORD = "";
    
    @Override
    public Account findAccountByEmail(String email) throws SQLException{
        Account account = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            
        } finally {
            if(resultSet != null){
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return account;
    }
    
    @Override
    public Account findAccountByEmailAndPassword(String email, String password) throws SQLException, ClassNotFoundException{
        Account account = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseUtil.getDatabaseConnection();
            if(connection != null){
                preparedStatement = connection.prepareStatement(FIND_ACCOUNT_BY_EMAIL_AND_PASSWORD);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
            }
        } finally {
            if(resultSet != null){
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return account;
    }

    public void save(){
        Connection connection = null;
        try {
            connection = DatabaseUtil.getDatabaseConnection();
            if(connection != null){
                connection.setAutoCommit(false);
//                connection.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
