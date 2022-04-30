package com.troc.controller;

import com.troc.dto.ContactDTO;
import com.troc.dto.UserDTO;
import com.troc.entity.Contact;
import com.troc.service.UserService;
import com.troc.service.impl.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

    private final ContactService contactService;
    private final UserService userService;

    public ContactController(ContactService contactService, UserService userService) {
        this.contactService = contactService;
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<ContactDTO> findContact(@PathVariable("userId") Long id) {
        Long contactId = userService.findUserDTOById(id).getContactId();
        return new ResponseEntity<>(contactService.findContact(contactId), HttpStatus.OK);
    }
}
