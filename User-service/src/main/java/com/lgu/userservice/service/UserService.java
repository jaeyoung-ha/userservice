package com.lgu.userservice.service;

import com.lgu.userservice.dto.UserDto;
import com.lgu.userservice.jpa.UserEntity;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);

    Iterable<UserEntity> getUserByAll();

}
