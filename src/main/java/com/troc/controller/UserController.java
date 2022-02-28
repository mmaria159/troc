package com.troc.controller;


import com.troc.entity.Contact;
import com.troc.entity.Product;
import com.troc.entity.User;
import com.troc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUserById(id), HttpStatus.OK);
    }

    @PostMapping("/{id}/addContact")
    public void addContactToUser(@PathVariable Long id, @RequestBody Contact contact) {
        User userFromDb = userService.findUserById(id);
        userFromDb.setContact(contact);
        userService.saveUser(userFromDb);
    }

    @PostMapping("/{id}/addProduct")
    public void addProductToUser(@PathVariable Long id, @RequestBody Product product) {
        User userFromDb = userService.findUserById(id);
        userFromDb.addProduct(product);
        userService.saveUser(userFromDb);
    }


}
