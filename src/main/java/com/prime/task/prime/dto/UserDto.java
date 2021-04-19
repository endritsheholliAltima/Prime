package com.prime.task.prime.dto;

import com.prime.task.prime.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String username;
    private String password;
    private String email;
    private String name;

    public User getUserFromDto() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);

        return user;
    }

}
