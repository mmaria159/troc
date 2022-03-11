package com.troc.service;

import com.troc.dto.UserDTO;
import com.troc.dto.UserDetailsDTO;
import com.troc.entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers();

    void saveUser(UserDTO userDTO);

    UserDTO findUserById(Long id);

    UserDetailsDTO findDetailedUserById(Long id);

    Long deleteUserById(Long id);

}
