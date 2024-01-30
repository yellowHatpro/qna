package dev.yellowhatpro.qnabackend.utils;

import dev.yellowhatpro.qnabackend.data.Answer;
import dev.yellowhatpro.qnabackend.data.Question;
import dev.yellowhatpro.qnabackend.data.User;
import dev.yellowhatpro.qnabackend.dto.AnswerDto;
import dev.yellowhatpro.qnabackend.dto.QuestionDto;
import dev.yellowhatpro.qnabackend.dto.UserDto;
import org.bson.types.ObjectId;

import java.util.stream.Collectors;

public class ModelDtoMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto(
                user.getId().toString(),
                user.getFirstName(),
                user.getSecondName(),
                user.getUsername(),
                user.getAddress(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getQuestionsAsked()
                        .stream()
                        .map(ModelDtoMapper::toQuestionDto)
                        .collect(Collectors.toList()),
                user.getAnswers()
                        .stream()
                        .map(ModelDtoMapper::toAnswerDto)
                        .collect(Collectors.toList()),
                user.getConnections()
                        .stream()
                        .map(ModelDtoMapper::toUserDto)
                        .collect(Collectors.toList())
        );
    }

    public static User toUser(UserDto userDto) {
        if (userDto.getId().isBlank()){
            userDto.setId((new ObjectId()).toString());
        }
        return new User(
                new ObjectId(userDto.getId()),
                userDto.getFirstName(),
                userDto.getSecondName(),
                userDto.getUsername(),
                userDto.getAddress(),
                userDto.getEmail(),
                userDto.getPhoneNumber(),
                userDto.getQuestionsAsked()
                        .stream()
                        .map(ModelDtoMapper::toQuestion)
                        .collect(Collectors.toList()),
                userDto.getAnswers()
                        .stream()
                        .map(ModelDtoMapper::toAnswer)
                        .collect(Collectors.toList()),
                userDto.getConnections()
                        .stream().map(ModelDtoMapper::toUser)
                        .collect(Collectors.toList())
        );
    }

    public static QuestionDto toQuestionDto(Question question) {
        return new QuestionDto(
                question.getId().toString(),
                question.getTitle(),
                question.getDescription(),
                question.getDateAsked(),
                question.getIsResolved(),
                question.getTopics(),
                question.getAnswers()
                        .stream()
                        .map(ModelDtoMapper::toAnswerDto)
                        .collect(Collectors.toList()),
                ModelDtoMapper.toUserDto(question.getQuestioner())
        );
    }

    public static Question toQuestion(QuestionDto questionDto) {
        if (questionDto.getId().isBlank()){
            questionDto.setId((new ObjectId()).toString());
        }
        return new Question(
                new ObjectId(questionDto.getId()),
                questionDto.getTitle(),
                questionDto.getDescription(),
                questionDto.getDateAsked(),
                questionDto.getIsResolved(),
                questionDto.getTopics(),
                questionDto.getAnswers()
                        .stream()
                        .map(ModelDtoMapper::toAnswer)
                        .collect(Collectors.toList()),
                ModelDtoMapper.toUser(questionDto.getQuestioner())
        );
    }

    public static AnswerDto toAnswerDto(Answer answer) {
        return new AnswerDto(
                answer.getId().toString(),
                answer.getDateAsked(),
                answer.getTitle(),
                answer.getBody(),
                answer.getTotalUpvotes(),
                ModelDtoMapper.toUserDto(answer.getUser()),
                ModelDtoMapper.toQuestionDto(answer.getQuestion())
        );
    }

    public static Answer toAnswer(AnswerDto answerDto) {
        if (answerDto.getId().isBlank()){
            answerDto.setId((new ObjectId()).toString());
        }
        return new Answer(
                new ObjectId(answerDto.getId()),
                answerDto.getDateAsked(),
                answerDto.getTitle(),
                answerDto.getBody(),
                answerDto.getTotalUpvotes(),
                ModelDtoMapper.toUser(answerDto.getUser()),
                ModelDtoMapper.toQuestion(answerDto.getQuestion())
        );
    }
}
