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
    private Long id;
    private Long phone;
    private String email;
    private String facebook;

    //@JsonIgnore
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH, CascadeType.REFRESH,CascadeType.MERGE},
            mappedBy = "contact",fetch = FetchType.LAZY)
    private User user;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH, CascadeType.REFRESH,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;


}
