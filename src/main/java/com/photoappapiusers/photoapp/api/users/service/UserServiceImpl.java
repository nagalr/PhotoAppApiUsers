package com.photoappapiusers.photoapp.api.users.service;

import com.photoappapiusers.photoapp.api.users.shared.UserDto;

import java.util.UUID;

public class UserServiceImpl implements UsersService {

    @Override
    public UserDto createUser(UserDto userDetails) {

        userDetails.setUserId(UUID.randomUUID().toString());


        return null;
    }

}
