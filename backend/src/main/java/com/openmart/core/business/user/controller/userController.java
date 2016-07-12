package com.openmart.core.business.user.controller;

import com.openmart.core.business.user.model.*;
import com.openmart.core.business.user.service.UserService;
import org.hibernate.validator.internal.xml.MethodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Nawa on 7/10/2016.
 */
//user controller
@RestController
public class UserController {
   @Autowired
    private UserService userService;

    @RequestMapping("/control")
    public void setText() {
        System.out.println("Caught in controller");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user){
        System.out.println("inside register user in controller ****************************");
        userService.addUser(user);
    }

    @RequestMapping(value = "/login/{username}", method = RequestMethod.POST)
    public void getUserFromUsername(@RequestBody Login login){
        System.out.println(login.toString());
        System.out.println("inside login in controller **********************************");
        System.out.println(userService.findUser(login));
    }

    @RequestMapping(value = "/update/{username}", method = RequestMethod.POST)
    public void updateProfile(@RequestBody BillingAddress billingAddress, @RequestBody ShippingAddress shippingAddress,@RequestBody UserImage image, String username) {
        System.out.println("inside update use details in controller **********************************");
        userService.addUpdatesToUser(username, billingAddress, shippingAddress, image);
    }
}
