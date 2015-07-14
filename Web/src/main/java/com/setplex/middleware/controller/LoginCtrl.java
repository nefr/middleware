package com.setplex.middleware.controller;

import com.setplex.middleware.model.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginCtrl {

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/login", method = RequestMethod.POST)
    public UserDTO getPackages(@RequestBody UserDTO user) {
        if(("user1").equalsIgnoreCase(user.getUsername())) {
            return user;
        }else {
            return null;
        }
    }
}
