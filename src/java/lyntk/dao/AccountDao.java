package lyntk.dao;

import java.sql.SQLException;
import javax.naming.NamingException;
import lyntk.models.Account;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public interface AccountDao {
    Account findAccountByEmail(String email) throws SQLException, NamingException;
    Account findAccountByEmailAndPassword(String email, String password) throws SQLException, NamingException;
    boolean save(Account account) throws SQLException, NamingException;
}
