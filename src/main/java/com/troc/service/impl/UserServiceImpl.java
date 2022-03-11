package com.troc.service.impl;

import com.troc.dto.UserDTO;
import com.troc.dto.UserDetailsDTO;
import com.troc.exceptions.UserNotFoundException;
import com.troc.mapper.UserMapper;
import com.troc.repository.UserRepository;
import com.troc.entity.User;
import com.troc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        userRepository.save(userMapper.dtoToUser(userDTO));
    }

    @Override
    public List<UserDTO> findAllUsers() {
        //////de lucru
        List<User> users = new ArrayList<>(userRepository.findAll());
        return userMapper.userToUserDTO(users);
    }

    public UserDTO findUserById(Long id) {
        User user = userRepository.getById(id);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return userMapper.userToUserDTO(user);
    }

    @Override
    public UserDetailsDTO findDetailedUserById(Long id) {
        User user = userRepository.findDetailedUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return userMapper.userDetailsToUserDetailsDTO(user);
    }

    @Override
    public Long deleteUserById(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
