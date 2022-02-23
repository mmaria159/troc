package com.troc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long id;
    private Long phone;
    private String email;
    private String facebook;

    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL)
    private User user;
}
