package com.troc.service;

import com.troc.entity.Email;

import javax.mail.MessagingException;

public interface EmailService {

    void sendSimpleMail(Email email) ;

    void sendMailWithAttachment(Email email) throws MessagingException;

}
