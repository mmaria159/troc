package com.troc.mapper;

import com.troc.dto.AddressDTO;
import com.troc.dto.ContactDTO;
import com.troc.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public ContactDTO contactToContactDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();

        contactDTO.setId(contact.getId());
        contactDTO.setPhone(contact.getPhone());
        contactDTO.setEmail(contact.getEmail());
        contactDTO.setFacebook(contact.getFacebook());

        AddressDTO addressDTO = AddressDTO.builder()
                .id(contact.getAddress().getId())
                .postalCode(contact.getAddress().getPostalCode())
                .streetName(contact.getAddress().getStreetName())
                .country(contact.getAddress().getCountry())
                .streetNumber(contact.getAddress().getStreetNumber())
                .town(contact.getAddress().getTown())
                .village(contact.getAddress().getVillage())
                .build();

        contactDTO.setAddressDTO(addressDTO);

        return contactDTO;
    }
}
