package dev.yellowhatpro.qnabackend.service;


import dev.yellowhatpro.qnabackend.dto.UserDtoRequest;
import dev.yellowhatpro.qnabackend.dto.UserDtoResponse;

import java.util.Optional;

public interface UserService {
    UserDtoResponse createUser(UserDtoRequest user);
    Optional<UserDtoResponse> getUserById(String userId);
    Optional<UserDtoResponse> getUserByName(String name);
    Optional<UserDtoResponse> getUserByEmail(String email);
    UserDtoResponse updateUser(UserDtoRequest user);
    void deleteUserById(String userId);
}
