package com.troc.dto;


import com.troc.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDTO
{
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;

    private Long phone;
    private String email;
    private String facebook;
    private String country;
    private String town;
    private String village;
    private String postalCode;
    private String region;
    private String streetName;
    private String streetNumber;
    private List<Product> products;

}
