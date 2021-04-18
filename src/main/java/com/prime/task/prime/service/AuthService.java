package com.prime.task.prime.service;

import com.prime.task.prime.dto.UserDTO;

public interface AuthService {

    UserDTO login(String username, String password);
}
