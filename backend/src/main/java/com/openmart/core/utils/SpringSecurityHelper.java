package com.openmart.core.utils;

import com.openmart.core.business.user.model.User;
import com.openmart.core.business.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by user on 12-Jul-16.
 */
@Component
public class SpringSecurityHelper {

    private static final String ATTR_KEY_USER = "user";

    @Autowired
    private UserService userService;

    public UserDetails getAuthenticatedUser(){
        return null;
    }

    public User getCurrentUserFromSession(HttpServletRequest request){
        Object object = request.getSession().getAttribute(ATTR_KEY_USER);
        if(object != null && object instanceof User ){
            return (User)object;
        }
        return null;
    }

    public User getDemoUser(){
       return userService.getAllUsers().get(0);
    }
}
