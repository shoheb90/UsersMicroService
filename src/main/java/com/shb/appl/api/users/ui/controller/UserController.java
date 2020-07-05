package com.shb.appl.api.users.ui.controller;
/*
   @Author      : Shoheb
   Description  : User Controller class
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    Environment environment;

    @GetMapping("/status/check")
    public String getStatus(){
        return "Working on port : "+ environment.getProperty("local.server.port");
    }
}
