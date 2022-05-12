package com.troc.controller;

import com.troc.dto.ContactDTO;
import com.troc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final UserService userService;

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<ContactDTO> findContactByUserId(@PathVariable("userId") Long id) {
        ContactDTO contact = userService.getUserContacts(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
}
