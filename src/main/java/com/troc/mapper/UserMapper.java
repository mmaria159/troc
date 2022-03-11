package com.troc.mapper;

import com.troc.dto.UserDTO;

import com.troc.dto.UserDetailsDTO;
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
        return userDTO;
    }

    public UserDetailsDTO userDetailsToUserDetailsDTO(User user) {
        UserDetailsDTO userDetails = new UserDetailsDTO();
        userDetails.setId(user.getId());
        userDetails.setFirstName(user.getFirstName());
        userDetails.setLastName(user.getLastName());
        userDetails.setGender(user.getGender());
        userDetails.setDateOfBirth(user.getDateOfBirth());
        if (user.getContact() != null) {
            userDetails.setPhone(user.getContact().getPhone());
            userDetails.setEmail(user.getContact().getEmail());
            userDetails.setFacebook(user.getContact().getFacebook());
            if (user.getContact().getAddress() != null) {
                userDetails.setCountry(user.getContact().getAddress().getCountry());
                userDetails.setTown(user.getContact().getAddress().getTown());
                userDetails.setVillage(user.getContact().getAddress().getVillage());
                userDetails.setPostalCode(user.getContact().getAddress().getPostalCode());
                userDetails.setStreetName(user.getContact().getAddress().getStreetName());
                userDetails.setStreetNumber(user.getContact().getAddress().getStreetNumber());
            }
        }
        return userDetails;
    }

    public List<UserDTO> userToUserDTO(List<User> users) {
        return users.stream().map(this::userToUserDTO).collect(Collectors.toList());
    }

    public User dtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setGender(userDTO.getGender());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        return user;
    }

    public List<User> dtoToUser(List<UserDTO> dtoUsers) {
        return dtoUsers.stream().map(this::dtoToUser).collect(Collectors.toList());
    }

}
