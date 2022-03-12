package com.troc.controller;

import com.troc.dto.UserDTO;
import com.troc.entity.Contact;
import com.troc.entity.Product;
import com.troc.entity.User;
import com.troc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUserDTOById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findUserDTOById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> addNewUser(@RequestBody User user) {
        UserDTO savedUserDTO = userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUserDTO.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUserById(id), HttpStatus.OK);
    }

    @PostMapping("/{id}/addContact")
    public ResponseEntity<UserDTO> addContactToUser(@PathVariable Long id, @RequestBody Contact contact) {
        UserDTO savedUserDTO = userService.addContactToUser(id, contact);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUserDTO.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PostMapping("/{id}/addProduct")
    public ResponseEntity<UserDTO> addProductToUser(@PathVariable Long id, @RequestBody Product product) {
        UserDTO savedUserDTO = userService.addProductToUser(id, product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUserDTO.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
