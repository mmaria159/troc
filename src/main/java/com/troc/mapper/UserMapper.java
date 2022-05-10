package com.troc.mapper;

import com.troc.dto.UserDTO;
import com.troc.entity.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ContactMapper contactMapper;
    private final ProductMapper productMapper;

    public UserDTO mapToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .gender(user.getGender()).dateOfBirth(user.getDateOfBirth())
                .contactDTO(contactMapper.mapToContactDTO(user.getContact()))
                .products(productMapper.mapToProductDTO(user.getProducts()))
                .build();
    }

    public List<UserDTO> mapToUserDTO(List<User> users) {
        return users.stream().map(this::mapToUserDTO).collect(Collectors.toList());
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
