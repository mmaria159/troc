package com.troc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long phone;
    private String email;
    private String facebook;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH, CascadeType.REFRESH,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;


}
