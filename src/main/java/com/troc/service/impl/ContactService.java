package com.troc.service.impl;

import com.troc.dto.ContactDTO;
import com.troc.entity.Address;
import com.troc.entity.Contact;
import com.troc.exceptions.ProductNotFoundException;
import com.troc.mapper.ContactMapper;
import com.troc.repository.ContactRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactService(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    @Transactional
    public ContactDTO findContact(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isEmpty()) {
            throw new ProductNotFoundException("Contact not found by id = " + id);
        }
        return contactMapper.contactToContactDTO(contact.get());
    }
}
