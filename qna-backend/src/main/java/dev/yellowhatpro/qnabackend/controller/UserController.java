package dev.yellowhatpro.qnabackend.controller;

import dev.yellowhatpro.qnabackend.dto.UserDto;
import dev.yellowhatpro.qnabackend.service.UserService;
import org.bson.types.ObjectId;
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
    public ResponseEntity<UserDto> getUserByName(@PathVariable String username) {

        Optional<UserDto> user = userService.getUserByName(username);
        return user.map(userDto -> new ResponseEntity<>(userDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> userById(@PathVariable ObjectId userId) {
        Optional<UserDto> userOptional = userService.getUserById(userId);
        return userOptional.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}