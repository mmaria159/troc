package com.troc.mapper;

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

        return contactDTO;
    }
}
