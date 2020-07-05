package com.shb.appl.api.users.ui.controller;
/*
   @Author      : Shoheb
   Description  : User Controller class
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/status/check")
    public String getStatus(){
        return "Working";
    }
}
