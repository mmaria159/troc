package com.troc.repository;

import com.troc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User AS u LEFT JOIN FETCH u.contact as c LEFT JOIN FETCH u.products LEFT JOIN FETCH c.address  WHERE u.id=:id")
    User findUserDetailsById(Long id);
}
