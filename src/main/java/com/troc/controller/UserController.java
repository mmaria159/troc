package com.troc.controller;

import com.troc.dto.ProductDTO;
import com.troc.dto.UserDTO;
import com.troc.entity.Contact;
import com.troc.entity.Product;
import com.troc.entity.Review;
import com.troc.entity.User;
import com.troc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
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

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("/{id}/addContact")
    public ResponseEntity<UserDTO> addContactToUser(@PathVariable Long id, @RequestBody Contact contact) {
        UserDTO savedUserDTO = userService.addContactToUser(id, contact);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUserDTO.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("/{id}/addProduct")
    public ResponseEntity<Long> addProductToUser(@PathVariable Long id, @RequestBody Product product) {
        Long productId = userService.addProductToUser(id, product);
        return new ResponseEntity<>(productId, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("/{id}/addReview")
    public ResponseEntity<UserDTO> addReviewToUser(@PathVariable Long id, @RequestBody Review review) {
        UserDTO savedUserDTO = userService.addReviewToUser(id, review);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUserDTO.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}/products")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<ProductDTO>> getUserProducts(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findUserDTOById(id).getProducts(), HttpStatus.OK);
    }
}
