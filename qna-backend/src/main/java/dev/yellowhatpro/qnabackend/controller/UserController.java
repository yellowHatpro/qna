package dev.yellowhatpro.qnabackend.controller;

import dev.yellowhatpro.qnabackend.dto.UserDtoRequest;
import dev.yellowhatpro.qnabackend.dto.UserDtoResponse;
import dev.yellowhatpro.qnabackend.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDtoResponse> getUserByName(@PathVariable String username) {

        Optional<UserDtoResponse> user = userService.getUserByName(username);
        return user.map(userDto -> new ResponseEntity<>(userDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDtoResponse> userById(@PathVariable String userId) {
        Optional<UserDtoResponse> userOptional = userService.getUserById(userId);
        return userOptional.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDtoResponse> createUser(@RequestBody UserDtoRequest userDtoRequest) {
        UserDtoResponse savedUser = userService.createUser(userDtoRequest);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}