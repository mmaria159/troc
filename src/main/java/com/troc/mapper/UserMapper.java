package com.troc.mapper;

import com.troc.dto.UserDTO;
import com.troc.entity.User;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setGender(user.getGender());
        userDTO.setDateOfBirth(user.getDateOfBirth());
        userDTO.setContactId(user.getContact().getId());

        return userDTO;
    }

    public List<UserDTO> userToUserDTO(List<User> users) {
        return users.stream().map(this::userToUserDTO).collect(Collectors.toList());
    }

    public User userDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setGender(userDTO.getGender());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        return user;
    }

    public List<User> userDTOToUser(List<UserDTO> dtoUsers) {
        return dtoUsers.stream().map(this::userDTOToUser).collect(Collectors.toList());
    }
}
