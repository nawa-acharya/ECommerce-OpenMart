package com.openmart.core.business.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Nawa on 7/10/2016.
 */
@Entity
public class Login {
    @Id
    @GeneratedValue
    private int loginId;
    private String username;
    private String password;
    public Login() {

    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getLoginId() {
        return loginId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
