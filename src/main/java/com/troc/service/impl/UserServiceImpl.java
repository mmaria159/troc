package com.troc.service.impl;

import com.troc.dto.UserDTO;
import com.troc.exceptions.UserNotFoundException;
import com.troc.repository.UserRepository;
import com.troc.entity.User;
import com.troc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.indigo.dtomapper.providers.specification.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Mapper mapper;

    @Override
    public List<UserDTO> findAllUsers() {
        return (List<UserDTO>) userRepository.findAll().stream().map(user -> mapper.map(user,UserDTO.class));
    }
/*
    @Override
    public UserDTO saveUser(User user) {
        return userRepository.save(user);
    }*/


    public UserDTO findUserById(Long id) {
        User result = userRepository.findById(id).orElseThrow(RuntimeException::new);
        // map result to desired type with depth
         UserDTO mappedResult = mapper.map(result,1, UserDTO.class);
        // return result
        return mappedResult;
    }

    @Override
    public Long deleteUserById(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
