package com.openmart.core.business.user.controller;

import com.openmart.core.business.user.model.User;
import com.openmart.core.business.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nawa on 7/10/2016.
 */
@RestController
public class userController {
   @Autowired
    private UserService userService;
/*
    @RequestMapping(value = "/")
    public String returnHome() {
        return "This directs to the home page";
    }

    private User user;
    @RequestMapping("/profile/{userName}")
    public String getUser(Model model, @PathVariable String userName){
        model.addAttribute("Users", userService.getUser(userName));
        return "this returns the user specified by the id";
    }

    @RequestMapping("/users")
    public String getAllUser(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return ("this returns all the user information");
    }

    @RequestMapping("/user/update/{userName}")
    public String updateUser(UserService service, @PathVariable String userName) {
        service.updateUser(userName);
        return ("redirect:/profile/{userName}");
    }

    @RequestMapping("/user/delete/{userName}")
    public String deleteUser(UserService service, @PathVariable String userName) {
        service.deleteUser(userName);
        return ("redirect:/profile/{userName}");
    }*/
    @RequestMapping("/control")
    public void setText() {
        System.out.println("Caught in controller");
    }

}
