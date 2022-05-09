package com.troc.service.impl;

import com.troc.dto.UserDTO;
import com.troc.entity.Contact;
import com.troc.entity.Product;
import com.troc.exceptions.UserNotFoundException;
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

    @Override
    @Transactional
    public UserDTO saveUser(User user) {
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDTO(savedUser);
    }

    @Override
    @Transactional
    public void addProductToUser(Long id, Product product) {
        User userFromDb = findUserById(id);
        userFromDb.addProduct(product);
        userRepository.save(userFromDb);
    }

    @Override
    @Transactional
    public UserDTO addContactToUser(Long id, Contact contact) {
        User userFromDb = findUserById(id);
        userFromDb.setContact(contact);
        return userMapper.userToUserDTO(userRepository.save(userFromDb));
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userMapper.userToUserDTO(userRepository.findAll());
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found by id - " + id));
    }

    @Override
    public UserDTO findUserDTOById(Long id) {
        User user = userRepository.findUserDetailsById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found by id:" + id));
        return userMapper.userToUserDTO(user);
    }

    @Override
    @Transactional
    public Long deleteUserById(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
