package com.troc.mapper;

import com.troc.dto.ContactDTO;
import com.troc.entity.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactMapper {
    private final AddressMapper addressMapper;

    public ContactDTO mapToContactDTO(Contact contact) {
        return ContactDTO.builder()
                .id(contact.getId())
                .phone(contact.getPhone())
                .email(contact.getEmail())
                .facebook(contact.getFacebook())
                .addressDTO(addressMapper.mapToAddressDto(contact.getAddress()))
                .build();
    }
}
