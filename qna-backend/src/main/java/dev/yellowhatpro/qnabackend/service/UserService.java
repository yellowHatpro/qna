package dev.yellowhatpro.qnabackend.service;


import dev.yellowhatpro.qnabackend.dto.UserDto;
import org.bson.types.ObjectId;

import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDto user);
    Optional<UserDto> getUserById(ObjectId userId);
    Optional<UserDto> getUserByName(String name);
    UserDto updateUser(UserDto user);
    void deleteUserById(ObjectId userId);
}
