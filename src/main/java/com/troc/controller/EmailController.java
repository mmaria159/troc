package com.troc.controller;

import com.troc.entity.Email;
import com.troc.service.EmailService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    // Sending a simple Email
    @PostMapping("/sendMail")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void sendMail(@RequestBody Email email) {
        emailService.sendSimpleMail(email);
    }

    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void sendMailWithAttachment(
            @RequestBody Email email) throws MessagingException {
        emailService.sendMailWithAttachment(email);


    }
}

