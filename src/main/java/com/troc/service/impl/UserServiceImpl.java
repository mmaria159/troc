package com.troc.service.impl;

import com.troc.dto.ContactDTO;
import com.troc.dto.UserDTO;
import com.troc.entity.Contact;
import com.troc.entity.Product;
import com.troc.entity.Review;
import com.troc.exceptions.UserNotFoundException;
import com.troc.mapper.ContactMapper;
import com.troc.mapper.UserMapper;
import com.troc.repository.UserRepository;
import com.troc.entity.User;
import com.troc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ContactMapper contactMapper;

    @Override
    @Transactional
    public UserDTO saveUser(User user) {
        User savedUser = userRepository.save(user);
        return userMapper.mapToUserDTO(savedUser);
    }

    @Override
    @Transactional
    public Long addProductToUser(Long id, Product product) {
        User userFromDb = findUserById(id);
        userFromDb.addProduct(product);
        User user = userRepository.save(userFromDb);
        return user.getIdOfLastAddedProduct();
    }

    @Override
    @Transactional
    public UserDTO addReviewToUser(Long id, Review review) {
        User userFromDb = findUserById(id);
        userFromDb.addReview(review);
        return userMapper.mapToUserDTO(userRepository.save(userFromDb));
    }

    @Override
    @Transactional
    public UserDTO addContactToUser(Long id, Contact contact) {
        User userFromDb = findUserById(id);
        userFromDb.setContact(contact);
        return userMapper.mapToUserDTO(userRepository.save(userFromDb));
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userMapper.mapToUserDTO(userRepository.findAll());
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found by id - " + id));
    }

    @Override
    @Transactional
    public UserDTO findUserDTOById(Long id) {
        User user = userRepository.findUserDetailsById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found by id:" + id));
        return userMapper.mapToUserDTO(user);
    }

    @Override
    @Transactional
    public Long deleteUserById(Long id) {
        userRepository.deleteById(id);
        return id;
    }

    @Override
    @Transactional
    public ContactDTO getUserContacts(Long id) {
        User user = userRepository.getById(id);
        return contactMapper.mapToContactDTO(user.getContact());
    }

    @Override
    @Transactional
    public UserDTO findUserByProductId(Long id) {
        return userMapper.mapToUserDTO(userRepository.findUserByProductId(id)
                .orElseThrow(()-> new UserNotFoundException("User not found by product id: " + id)));
    }
}
