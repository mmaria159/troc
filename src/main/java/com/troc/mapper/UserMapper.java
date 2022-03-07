package com.troc.mapper;

import com.troc.dto.UserDTO;
import com.troc.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
   // UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);
}
