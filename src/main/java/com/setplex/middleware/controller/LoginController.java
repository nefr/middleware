package com.setplex.middleware.controller;

import com.setplex.middleware.model.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/login", method = RequestMethod.POST)
    public  @ResponseBody UserDTO getPackages(@RequestBody UserDTO user) {
        if(("user1").equalsIgnoreCase(user.getUsername())) {
            return user;
        }else {
            return null;
        }
    }
}
