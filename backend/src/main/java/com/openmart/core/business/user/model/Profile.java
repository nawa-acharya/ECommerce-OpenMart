package com.openmart.core.business.user.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nawa on 7/11/2016.
 */
//user profile
@Entity
public class Profile {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    private UserImage image;

    public Profile() {

    }

    public Profile(UserImage image) {
        this.image = image;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserImage getImage() {
        return image;
    }

    public void setImage(UserImage image) {
        this.image = image;
    }
}
