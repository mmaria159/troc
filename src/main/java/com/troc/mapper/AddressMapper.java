package com.troc.mapper;

import com.troc.dto.AddressDTO;
import com.troc.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDTO mapToAddressDto(Address address) {
        if (address == null) return emptyAddress();
        return AddressDTO.builder()
                .id(address.getId())
                .country(address.getCountry())
                .town(address.getTown())
                .village(address.getVillage())
                .postalCode(address.getPostalCode())
                .streetName(address.getStreetName())
                .streetNumber(address.getStreetNumber())
                .build();
    }

    public AddressDTO emptyAddress(){
        return AddressDTO.builder().build();
    }
}
