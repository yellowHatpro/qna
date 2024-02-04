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

    @GetMapping("/find-by-username")
    public ResponseEntity<UserDtoResponse> getUserByName(@RequestParam(name="username", required = false) String username) {

        Optional<UserDtoResponse> user = userService.getUserByName(username);
        return user.map(userDto -> new ResponseEntity<>(userDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/find-by-userId")
    public ResponseEntity<UserDtoResponse> userById(@RequestParam(name = "userId", required = false) String userId) {
        Optional<UserDtoResponse> userOptional = userService.getUserById(userId);
        return userOptional.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping("/find-by-email")
    public ResponseEntity<UserDtoResponse> userByEmail(@RequestBody String email) {
        Optional<UserDtoResponse> userOptional = userService.getUserByEmail(email);
        return userOptional.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDtoResponse> createUser(@RequestBody UserDtoRequest userDtoRequest) {
        UserDtoResponse savedUser = userService.createUser(userDtoRequest);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}