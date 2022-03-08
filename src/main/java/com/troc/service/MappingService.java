package com.troc.service;

import com.troc.dto.UserDTO;
import com.troc.entity.User;

public interface MappingService {

        UserDTO mapUserBasicInfo(User user);

        UserDTO mapUserWithTasks(User user);


}
