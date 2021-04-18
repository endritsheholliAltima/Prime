package com.prime.task.prime.service;


import com.prime.task.prime.dto.UserDto;
import com.prime.task.prime.model.User;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}
