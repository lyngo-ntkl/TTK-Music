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
import lyntk.enums.AccountRole;
import lyntk.models.Account;
import lyntk.utils.DatabaseUtil;

/**
 *
 * @author Dell
 */
public class AccountDaoImpl implements AccountDao {
    private static final String FIND_ACCOUNT_BY_EMAIL_AND_PASSWORD = "SELECT account_id, email, password, username, role_id FROM accounts "
            + "WHERE email = ? AND password = ? AND status = ?";
    private static final String FIND_ACCOUNT_BY_EMAIL = "SELECT account_id, email, password, username FROM accounts "
            + "WHERE email = ?";
    private static final String SAVE = "INSERT INTO accounts(account_id, email, password, username, role_id, status) VALUES (?, ?, ?, ?, ?, ?)";
    
    @Override
    public Account findAccountByEmail(String email) throws SQLException, ClassNotFoundException{
        Account account = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseUtil.getDatabaseConnection();
            if(connection != null){
                preparedStatement = connection.prepareStatement(FIND_ACCOUNT_BY_EMAIL);
                preparedStatement.setString(1, email);
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    String id = resultSet.getString("account_id");
                    account = new Account(id);
                }
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
                preparedStatement.setBoolean(3, true);
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    String id = resultSet.getString("account_id");
                    String username = resultSet.getString("username");
                    String role = resultSet.getString("role_id");
                    account = new Account(id, email, password, username, AccountRole.valueOf(role), true);
                }
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

    @Override
    public boolean save(Account account) throws SQLException, ClassNotFoundException{
        boolean check = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseUtil.getDatabaseConnection();
            if(connection != null){
                preparedStatement = connection.prepareStatement(SAVE);
                preparedStatement.setString(1, account.getId());
                preparedStatement.setString(2, account.getEmail());
                preparedStatement.setString(3, account.getPassword());
                preparedStatement.setString(4, account.getUsername());
                preparedStatement.setString(5, account.getRole().name());
                preparedStatement.setBoolean(6, account.isActiveStatus());
                check = preparedStatement.executeUpdate() > 0;
            }
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return check;
    }
}
