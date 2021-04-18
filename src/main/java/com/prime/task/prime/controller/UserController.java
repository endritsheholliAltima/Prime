package com.prime.task.prime.controller;

        import com.prime.task.prime.service.AuthService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

        import static com.prime.task.prime.common.security.GenerateToken.*;
        import com.prime.task.prime.dto.UserDTO;

@RestController
public class UserController {

    @Autowired
    private AuthService authService;

    @PostMapping("user")
    public UserDTO login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
       UserDTO userDTO = authService.login(username, pwd);
        return userDTO;

    }

}