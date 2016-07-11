package com.openmart.core.business.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Null;

/**
 * Created by Nawa on 7/10/2016.
 */
@Entity
public class Login {
    @Id
    private int id;
    private String username;
    private String password;

    public Login() {

    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
