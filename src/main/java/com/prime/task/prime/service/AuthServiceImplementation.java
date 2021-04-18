package com.prime.task.prime.service;

import com.prime.task.prime.dto.UserDTO;
import org.springframework.stereotype.Service;

import static com.prime.task.prime.common.security.GenerateToken.getJWTToken;

@Service
public class AuthServiceImplementation implements AuthService {

    @Override
    public UserDTO login(String username, String password) {

        String token = getJWTToken(username);
        UserDTO userDTO = new UserDTO();
        userDTO.setUser(username);
        userDTO.setToken(token);

        return userDTO;
    }
}
