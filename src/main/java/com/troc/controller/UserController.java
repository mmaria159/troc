package com.troc.controller;


import com.troc.entity.Contact;
import com.troc.entity.User;
import com.troc.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> showAllUsers() {
        List<User> allUser = userService.getAllUsers();
        return allUser;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        User user = userService.getUser(id);
        return user;
    }

    @PostMapping("/user")
    public User addNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user ) {
        userService.saveUser(user);
        return user;
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "Employee with ID = " + id + " was deleted";
    }

    @PostMapping("/addContact/{id}")
    public void saveContact(@PathVariable Long id, @RequestBody Contact contact) {
        User userFromDb = userService.getUser(id);
        userFromDb.setContact(contact);
        userService.saveUser(userFromDb);
    }


}
