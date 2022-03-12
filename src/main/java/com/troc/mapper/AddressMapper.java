package com.troc.mapper;

import com.troc.dto.AddressDTO;
import com.troc.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDTO contactToContactDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId(address.getId());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setTown(address.getTown());
        addressDTO.setVillage(address.getVillage());
        addressDTO.setPostalCode(address.getPostalCode());
        addressDTO.setStreetName(address.getStreetName());
        addressDTO.setStreetNumber(address.getStreetNumber());

        return addressDTO;
    }
}
