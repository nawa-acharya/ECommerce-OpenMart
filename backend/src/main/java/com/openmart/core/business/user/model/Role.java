package com.openmart.core.business.user.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Nawa on 7/10/2016.
 */
//user role
//public enum Role {
//    ROLE_USER,
//    ROLE_ADMIN
//}

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Role(){}

    public Role(String role){
        this.role =role;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

/*    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }*/

    private String role;

/*    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private Set<User> users*/;

}
