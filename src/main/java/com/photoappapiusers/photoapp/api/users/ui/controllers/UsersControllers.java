package com.photoappapiusers.photoapp.api.users.ui.controllers;

import com.photoappapiusers.photoapp.api.users.service.UsersService;
import com.photoappapiusers.photoapp.api.users.shared.UserDto;
import com.photoappapiusers.photoapp.api.users.ui.model.CreateUserRequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersControllers {

    @Autowired
    private Environment env;

    @Autowired
    UsersService usersService;

    @GetMapping("status/check")
    public String status(){

        return "working on port: " +
                env.getProperty("local.server.port");
    }

    @PostMapping
    public String createUser(@Valid @RequestBody CreateUserRequestModel userDetails){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
        usersService.createUser(userDto);

        return "create user method is called";
    }


}
