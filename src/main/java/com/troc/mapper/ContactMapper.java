package com.troc.mapper;

import com.troc.dto.AddressDTO;
import com.troc.dto.ContactDTO;
import com.troc.entity.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactMapper {
    private final AddressMapper addressMapper;

    public ContactDTO mapToContactDTO(Contact contact) {
        if (contact == null) return emptyContact();
        AddressDTO addressDTO = addressMapper.mapToAddressDto(contact.getAddress());
        return ContactDTO.builder()
                .id(contact.getId())
                .phone(contact.getPhone())
                .email(contact.getEmail())
                .facebook(contact.getFacebook())
                .addressDTO(addressDTO)
                .build();
    }

    private ContactDTO emptyContact() {
        return ContactDTO.builder().build();
    }
}
