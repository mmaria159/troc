package com.troc.repository;

import com.troc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query("SELECT u FROM User AS u LEFT JOIN FETCH u.contact as c LEFT JOIN FETCH u.products LEFT JOIN FETCH c.address  WHERE u.id=:id")
    User findUserDetailsById(Long id);


}
