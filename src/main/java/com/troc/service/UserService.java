package com.troc.service;

import com.troc.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User saveUser(User user);

    User findUserById(Long id);

    Long deleteUserById(Long id);

}
