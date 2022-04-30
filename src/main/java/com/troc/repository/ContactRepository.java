package com.troc.repository;

import com.troc.entity.Contact;
import com.troc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
