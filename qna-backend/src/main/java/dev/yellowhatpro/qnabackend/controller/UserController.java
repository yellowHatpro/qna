package dev.yellowhatpro.qnabackend.controller;

import dev.yellowhatpro.qnabackend.data.User;
import dev.yellowhatpro.qnabackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Optional<User>> user(@PathVariable String username) {
        return new ResponseEntity<>(userService.userByUsername(username), HttpStatus.OK);
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
}