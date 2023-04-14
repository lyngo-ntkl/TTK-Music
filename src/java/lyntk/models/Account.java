/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyntk.models;

import lyntk.enums.AccountRole;

/**
 *
 * @author Dell
 */
public class Account {
    private String id;
    private String email;
    private String password;
    private String username;
    private AccountRole role;

    public Account() {
    }

    public Account(String email, String password, String username, AccountRole role) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AccountRole getRole() {
        return role;
    }

    public void setRole(AccountRole role) {
        this.role = role;
    }
    
    
}
