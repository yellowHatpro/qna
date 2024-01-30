package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.data.User;
import dev.yellowhatpro.qnabackend.dto.UserDto;
import dev.yellowhatpro.qnabackend.repo.UserRepository;
import dev.yellowhatpro.qnabackend.utils.ModelDtoMapper;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = ModelDtoMapper.toUser(userDto);
        User savedUser = userRepository.insert(user);
        return ModelDtoMapper.toUserDto(savedUser);
    }

    @Override
    public Optional<UserDto> getUserById(ObjectId userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.map(user -> Optional.of(ModelDtoMapper.toUserDto(user))).orElse(null);
    }

    @Override
    public Optional<UserDto> getUserByName(String name) {
        Optional<User> user = userRepository.findByUsername(name);
        return user.map(value -> Optional.of(ModelDtoMapper.toUserDto(value))).orElse(null);
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(new ObjectId(user.getId())).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setId(new ObjectId(user.getId()));
        existingUser.setSecondName(user.getSecondName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setAnswers(user.getAnswers().stream().map(ModelDtoMapper::toAnswer).collect(Collectors.toList()));
        existingUser.setConnections(user.getConnections().stream().map(ModelDtoMapper::toUser).collect(Collectors.toList()));
        existingUser.setQuestionsAsked(user.getQuestionsAsked().stream().map(ModelDtoMapper::toQuestion).collect(Collectors.toList()));
        User updatedUser = userRepository.save(existingUser);
        return ModelDtoMapper.toUserDto(updatedUser);
    }

    @Override
    public void deleteUserById(ObjectId userId) {
        userRepository.deleteById(userId);
    }
}
