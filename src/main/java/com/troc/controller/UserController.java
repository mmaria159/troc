package com.troc.controller;

import com.troc.entity.User;
import com.troc.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
