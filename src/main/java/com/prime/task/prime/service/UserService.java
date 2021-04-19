package com.prime.task.prime.service;


import com.prime.task.prime.dto.UserDto;
import com.prime.task.prime.model.User;

public interface UserService {
    User save(UserDto user);

}
