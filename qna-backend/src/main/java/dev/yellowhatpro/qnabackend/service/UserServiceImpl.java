package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.data.User;
import dev.yellowhatpro.qnabackend.dto.UserDtoRequest;
import dev.yellowhatpro.qnabackend.dto.UserDtoResponse;
import dev.yellowhatpro.qnabackend.repo.UserRepository;
import dev.yellowhatpro.qnabackend.utils.ModelMapper;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDtoResponse createUser(UserDtoRequest userDtoRequest) {
        User user = modelMapper.toEntity(modelMapper.toResponseModel(userDtoRequest));
        User savedUser = userRepository.insert(user);
        return modelMapper.toResponseModel(savedUser);
    }

    @Override
    public Optional<UserDtoResponse> getUserById(String userId) {
        Optional<User> optionalUser = userRepository.findUserById(userId);
        return optionalUser.map(user -> Optional.of(modelMapper.toResponseModel(user))).orElse(null);
    }

    @Override
    public Optional<UserDtoResponse> getUserByName(String name) {
        Optional<User> user = userRepository.findByUsername(name);
        return user.map(value -> modelMapper.toResponseModel(value)).or(Optional::empty);
    }

    @Override
    public Optional<UserDtoResponse> getUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        return user.map(value -> modelMapper.toResponseModel(value)).or(Optional::empty);
    }

    @Override
    public UserDtoResponse updateUser(UserDtoRequest user) {
        User existingUser = userRepository.findById(new ObjectId(user.getId())).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setId(user.getId());
        existingUser.setSecondName(user.getSecondName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setAnswerIds(user.getAnswerIds());
        existingUser.setQuestionsAskedIds(user.getQuestionsAskedIds());
        userRepository.save(existingUser);
        return modelMapper.toResponseModel(user);
    }

    @Override
    public void deleteUserById(String userId) {
        userRepository.deleteUserById(userId);
    }
}
