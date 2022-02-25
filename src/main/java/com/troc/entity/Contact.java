package com.troc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH, CascadeType.REFRESH,CascadeType.MERGE},
            mappedBy = "contact")
    private User user;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH, CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "address_id")
    private Address address;


}
