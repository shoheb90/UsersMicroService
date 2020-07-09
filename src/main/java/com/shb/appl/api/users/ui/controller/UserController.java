package com.shb.appl.api.users.ui.controller;
/*
   @Author      : Shoheb
   Description  : User Controller class
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import com.shb.appl.api.users.ui.model.CreateUserRequestModel;
import com.shb.appl.api.users.ui.model.CreateUserResponseModel;
import com.shb.appl.api.users.ui.service.UserService;
import com.shb.appl.api.users.ui.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    Environment environment;

    @Autowired
    UserService userService;

    @GetMapping("/status/check")
    public String getStatus(){
        return "Working on port : "+ environment.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto =  modelMapper.map(userDetails,UserDto.class);

        UserDto createdUser = userService.createUser(userDto);

        //Model mapper used to copy data from source to destination i.e. createdUser to CreateUserResponseModel
        CreateUserResponseModel returnValue = modelMapper.map(createdUser,CreateUserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

}
