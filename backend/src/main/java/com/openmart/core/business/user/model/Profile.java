package com.openmart.core.business.user.model;

import javax.persistence.*;

/**
 * Created by Nawa on 7/11/2016.
 */
@Entity
public class Profile {
    @Id
    @GeneratedValue
    private int id;
    private String firstname;
    private String lastname;
    private String dateOfBirth;
    @Lob
    private String description;
    private String gender;
    @OneToOne(cascade = CascadeType.ALL)
    private UserImage image;


    public Profile() {

    }

    public Profile(UserImage image, String firstname, String lastname, String description) {
        this.image = image;
        this.firstname = firstname;
        this.lastname = lastname;
        this.description = description;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
