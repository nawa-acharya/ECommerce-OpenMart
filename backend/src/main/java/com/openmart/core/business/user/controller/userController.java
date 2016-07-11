package com.openmart.core.business.user.controller;

import com.openmart.core.business.user.model.Login;
import com.openmart.core.business.user.model.User;
import com.openmart.core.business.user.service.UserService;
import org.hibernate.validator.internal.xml.MethodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nawa on 7/10/2016.
 */
@RestController
public class userController {
   @Autowired
    private UserService userService;

    @RequestMapping("/control")
    public void setText() {
        System.out.println("Caught in controller");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void registerUser(){
        userService.addUser(new User("Nawa", new Login("user", "pass")));
    }

}
