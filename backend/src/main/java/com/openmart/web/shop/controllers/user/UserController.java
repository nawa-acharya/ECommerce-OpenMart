package com.openmart.web.shop.controllers.user;

import com.openmart.core.business.user.model.*;
import com.openmart.core.business.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Nawa on 7/10/2016.
 */
//controller user
@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "openmart/api/user")
public class UserController {
   @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody User registerUser(@RequestBody User user){
        System.out.println("inside register user in controller ****************************");
        userService.addUser(user);
        return user;
    }

    @RequestMapping(value= "/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody User showUserDetails(@RequestParam String username){
        return userService.getUser(username);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody User getUserFromUsername(@RequestBody Login login){
        System.out.println(login.toString());
        System.out.println("inside login in controller **********************************");
        return userService.findUser(login);
    }

    @RequestMapping(value = "profile/update/{username}", method = RequestMethod.POST)
    public @ResponseBody User updateProfile(@RequestBody Profile profile, @PathVariable String username) {
        System.out.println("inside update use details in controller **********************************");
        return userService.getUser(username);
    }
}
