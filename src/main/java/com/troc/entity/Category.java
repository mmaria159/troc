package com.troc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ECategory category;

    public Category() {
    }
}