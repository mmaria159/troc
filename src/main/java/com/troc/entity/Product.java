package com.troc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @Column(name = "date_of_addition")
    private Date dateOfAddition;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH, CascadeType.REFRESH,CascadeType.MERGE}, mappedBy = "product")
    private User user;
}
