package com.troc.entity;

import lombok.*;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    private String recipient;
    private String msgBody;
    private String subject;
}
