package lyntk.dao;

import java.sql.SQLException;
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
    Account findAccountByEmail(String email) throws SQLException;
    Account findAccountByEmailAndPassword(String email, String password) throws SQLException, ClassNotFoundException;
}
