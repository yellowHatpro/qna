package dev.yellowhatpro.qnabackend.controller;

import dev.yellowhatpro.qnabackend.data.User;
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
    public ResponseEntity<User> user(@PathVariable String username) {

        Optional<User> userOptional = userService.userByUsername(username);
        return userOptional.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> userById(@PathVariable String userId) {
        Optional<User> userOptional = userService.userById(userId);
        return userOptional.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(userService.createUser(payload.get("firstname"),
                payload.get("secondname"),
                payload.get("username"),
                payload.get("address"),
                payload.get("githubusername"),
                payload.get("email"),
                payload.get("phonenumber")
        ), HttpStatus.CREATED);
    }

    @PostMapping("/connection")
    public ResponseEntity<List<User>> getConnectionsOfUser(@RequestBody Map<String, String> payload) {
        Optional<User> userOptional = userService.userById(payload.get("userId"));
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new ResponseEntity<List<User>>(user.getConnections(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }
    }
}