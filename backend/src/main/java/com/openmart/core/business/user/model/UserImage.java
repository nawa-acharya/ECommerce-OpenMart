package com.openmart.core.business.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.File;

/**
 * Created by Nawa on 7/10/2016.
 */
@Entity
public class UserImage {
    @Id
    @GeneratedValue
    private int imageId;
    @Lob
    private File image;
    public UserImage() {

    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }
}

