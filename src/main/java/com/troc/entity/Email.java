package com.troc.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private int id;
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}