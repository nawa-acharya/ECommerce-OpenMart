package com.openmart.core.business.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.File;

/**
 * Created by Nawa on 7/10/2016.
 */
//image
@Entity
public class UserImage {
    @Id
    @GeneratedValue
    private int imageId;
    @Lob
    private File image;
    private byte[] byteImage;
    public UserImage() {

    }

    public UserImage(File image) {
        this.image = image;
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

    public byte[] getByteImage() {
        return byteImage;
    }

    public void setByteImage(byte[] byteImage) {
        this.byteImage = byteImage;
    }
}

