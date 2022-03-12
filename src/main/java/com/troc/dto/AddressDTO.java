package com.troc.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Long id;
    private String country;
    private String town;
    private String village;
    private String postalCode;
    private String streetName;
    private String streetNumber;
}
