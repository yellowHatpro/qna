package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.data.User;
import dev.yellowhatpro.qnabackend.repo.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(String firstName, String secondName, String username, String address, String githubUsername, String email, String phoneNumber){
        User user = new User(firstName, secondName, username, address, githubUsername, email, phoneNumber);
        userRepository.insert(user);
        return user;
    }

    public Optional<User> userByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }
    public Optional<User> userById(ObjectId id){
        return userRepository.findById(id);
    }
    public List<User> connections(ObjectId id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            return userOptional.get().getConnections();
        } else {
            return Collections.emptyList();
        }
    }
    public void deleteUser(ObjectId id){
        userRepository.deleteById(id);
    }
}
