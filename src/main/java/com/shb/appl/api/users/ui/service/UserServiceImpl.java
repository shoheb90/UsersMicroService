package com.shb.appl.api.users.ui.service;
/*
   @Author      : Shoheb
   Description  : 
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import com.shb.appl.api.users.ui.shared.UserDto;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        return null;
    }
}
