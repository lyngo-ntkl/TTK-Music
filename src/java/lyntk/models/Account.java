/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyntk.models;

import java.util.Date;
import java.util.UUID;
import lyntk.enums.AccountRole;

/**
 *
 * @author Dell
 */
public class Account {
    private final String id;
    private String email;
    private String password;
    private String username;
    private AccountRole role;
    private boolean activeStatus;

    public Account() {
        this.id = UUID.nameUUIDFromBytes((email + new Date()).getBytes()).toString();
    }

    public Account(String id) {
        this.id = id;
    }

    public Account(String email, String password, String username, AccountRole role, boolean activeStatus) {
        this.id = UUID.nameUUIDFromBytes((email + new Date()).getBytes()).toString();
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
        this.activeStatus = activeStatus;
    }

    public Account(String id, String email, String password, String username, AccountRole role, boolean activeStatus) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
        this.activeStatus = activeStatus;
    }

    public String getId() {
        return id;
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

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
}
