package com.troc.dto;

import com.troc.entity.Contact;
import com.troc.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.indigo.dtomapper.annotations.Property;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private Contact contact;
   // @Property(depth = 1)
    private List<Product> products;

}
