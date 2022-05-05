package com.troc.service.impl;

import com.troc.dto.ContactDTO;
import com.troc.entity.Address;
import com.troc.entity.Contact;
import com.troc.exceptions.ProductNotFoundException;
import com.troc.mapper.ContactMapper;
import com.troc.repository.ContactRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Contact not found by id = " + id));
        return contactMapper.contactToContactDTO(contact);
    }
}
