package com.openmart.core.business.user.controller;

import com.openmart.core.business.user.model.User;
import com.openmart.core.business.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Nawa on 7/10/2016.
 */
@Controller
public class userController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String returnHome() {
        return "This directs to the home page";
    }

    private User user;
    @RequestMapping("/profile")
    public String getUser(Model model, @PathVariable int id){
        model.addAttribute("Users", userService.getUser(id));
        return "this returns the user specified by the id";
    }

    @RequestMapping("/users")
    public String getAllUser(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return ("this returns all the user information");
    }

}
