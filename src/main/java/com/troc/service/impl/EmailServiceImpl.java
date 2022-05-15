package com.troc.service.impl;

import com.troc.entity.Email;

import com.troc.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendSimpleMail(Email email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(sender);
        mailMessage.setTo(email.getRecipient());
        mailMessage.setText(email.getMsgBody());
        mailMessage.setSubject(email.getSubject());

        javaMailSender.send(mailMessage);
    }

    public void sendMailWithAttachment(Email email) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(sender);
        mimeMessageHelper.setTo(email.getRecipient());
        mimeMessageHelper.setText(email.getMsgBody());
        mimeMessageHelper.setSubject(
                email.getSubject());

        FileSystemResource file = new FileSystemResource(new File(email.getAttachment()));
        mimeMessageHelper.addAttachment(file.getFilename(), file);

        javaMailSender.send(mimeMessage);
    }
}

