package com.photoappapiusers.photoapp.api.users.service;

import com.photoappapiusers.photoapp.api.users.data.UserEntity;
import com.photoappapiusers.photoapp.api.users.data.UsersRepository;
import com.photoappapiusers.photoapp.api.users.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UsersService {

    UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository){

        this.usersRepository = usersRepository;
    }

    @Override
    public UserDto createUser(UserDto userDetails) {

        userDetails.setUserId(UUID.randomUUID().toString());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
        userEntity.setEncryptedPassword("test");

        usersRepository.save(userEntity);
        return null;
    }

}
