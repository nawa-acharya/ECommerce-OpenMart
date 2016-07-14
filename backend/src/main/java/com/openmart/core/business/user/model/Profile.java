package com.openmart.core.business.user.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Nawa on 7/11/2016.
 */
@Entity
public class Profile {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String firstname = "not set";
    @NotBlank
    private String lastname = "not set";
    @NotNull
    private String dateOfBirth = "not set";
    @Lob
    @NotBlank
    private String description = "not set";
    private String gender = "male";
  //  @OneToOne(cascade = CascadeType.ALL)
    private String image = "profile";


    public Profile() {

    }

    public Profile(String firstname, String lastname, String description, String gender, String dateOfBirth, String image) {
        this.image = image;
        this.firstname = firstname;
        this.lastname = lastname;
        this.description = description;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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
