package com.troc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@Getter
@Setter
//@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    private String lastName;

   // @NotBlank
    @Size(max = 20)
    private String username;

    //@NotBlank
    @Size(max = 120)
    private String password;

   // @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private String gender;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Product> products;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }



    public void addProduct(Product product) {
        if (products == null) products = new ArrayList<>();
        product.setUser(this);
        products.add(product);
    }

}

