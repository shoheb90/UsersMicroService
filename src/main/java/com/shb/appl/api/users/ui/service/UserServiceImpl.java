package com.shb.appl.api.users.ui.service;
/*
   @Author      : Shoheb
   Description  : 
   >>>>>>>>>>>>>>>>>>>>> Annotations >>>>>>>>>>>>>>>>>>>>>  
   @      :   
   @      :   
   
 */

import com.shb.appl.api.users.ui.data.UserEntity;
import com.shb.appl.api.users.ui.data.UserRepository;
import com.shb.appl.api.users.ui.model.CreateUserResponseModel;
import com.shb.appl.api.users.ui.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    //Create constructor based dependency injection
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        //Map source object fields userDetails with Entity object fields to store data correctly in specific columns
        UserEntity userEntity = modelMapper.map(userDetails,UserEntity.class);
        userEntity.setEncryptedPassword("test");  //Temporory added as its not available for now

        userRepository.save(userEntity);

        UserDto returnValue = modelMapper.map(userEntity, UserDto.class);

        return returnValue;
    }
}
