package com.troc.service;

import com.troc.dto.UserDTO;
import com.troc.entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers();

   // UserDTO saveUser(User user);

    UserDTO findUserById(Long id);

    Long deleteUserById(Long id);

}
