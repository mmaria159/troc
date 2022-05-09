package com.troc.service;

import com.troc.dto.UserDTO;
import com.troc.entity.Contact;
import com.troc.entity.Product;
import com.troc.entity.Review;
import com.troc.entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers();

    UserDTO saveUser(User user);

    UserDTO addProductToUser(Long userID, Product product);
    UserDTO addReviewToUser(Long userID, Review review);

    UserDTO addContactToUser(Long id, Contact contact);

    UserDTO findUserDTOById(Long id);

    User findUserById(Long id);

    Long deleteUserById(Long id);

}
