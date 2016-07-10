package backend.src.main.java.com.openmart.core.user.domain;

import java.awt.*;
import java.io.File;

/**
 * Created by Nawa on 7/9/2016.
 */

public class UserImage {
    private int userImageId;
    private File image;

    public void setImage(File image) {
        this.image = image;
    }

    public File getImage() {
        return image;
    }

}
