package com.troc.service.impl;

import com.troc.dto.UserDTO;
import com.troc.dto.UserDetailsDTO;
import com.troc.exceptions.UserNotFoundException;
import com.troc.repository.UserRepository;
import com.troc.entity.User;
import com.troc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.indigo.dtomapper.providers.specification.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


  /*  @Override
    public List<UserDTO> findAllUsers() {
        return (List<UserDTO>) userRepository.findAll().stream().map(user -> mapper.map(user, UserDTO.class));
    }*/
/*
    @Override
    public UserDTO saveUser(User user) {
        return userRepository.save(user);
    }*/


    public UserDTO findUserById(Long id) {
        User user = userRepository.getById(id);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setGender(user.getGender());
        userDTO.setDateOfBirth(user.getDateOfBirth());
        return userDTO;
    }

    @Override
    public UserDetailsDTO findDetailedUserById(Long id) {
        User user = userRepository.findDetailedUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        UserDetailsDTO userDetails = new UserDetailsDTO();
        userDetails.setId(user.getId());
        userDetails.setFirstName(user.getFirstName());
        if (user.getContact() != null) {
            userDetails.setEmail(user.getContact().getEmail());
            userDetails.setFacebook(user.getContact().getFacebook());
            if (user.getContact().getAddress() != null) {
                userDetails.setCountry(user.getContact().getAddress().getCountry());
            }
        }
        return userDetails;
    }

    @Override
    public Long deleteUserById(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
