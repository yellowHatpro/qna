package dev.yellowhatpro.qnabackend.utils;

import dev.yellowhatpro.qnabackend.data.Answer;
import dev.yellowhatpro.qnabackend.data.Question;
import dev.yellowhatpro.qnabackend.data.User;
import dev.yellowhatpro.qnabackend.dto.*;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    //User
    public UserDtoResponse toResponseModel(UserDtoRequest userDtoRequest) {

        return UserDtoResponse
                .builder()
                .id(userDtoRequest.getId())
                .firstName(userDtoRequest.getFirstName())
                .secondName(userDtoRequest.getSecondName())
                .username(userDtoRequest.getUsername())
                .address(userDtoRequest.getAddress())
                .email(userDtoRequest.getEmail())
                .phoneNumber(userDtoRequest.getPhoneNumber())
                .image(userDtoRequest.getImage())
                .questionsAskedIds(userDtoRequest.getQuestionsAskedIds())
                .answerIds(userDtoRequest.getAnswerIds())
                .build();
    }

    public UserDtoResponse toResponseModel(User user) {

        return UserDtoResponse
                .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .secondName(user.getSecondName())
                .username(user.getUsername())
                .address(user.getAddress())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .image(user.getImage())
                .questionsAskedIds(user.getQuestionsAskedIds())
                .answerIds(user.getAnswerIds())
                .build();
    }

    public User toEntity(UserDtoResponse userDtoResponse) {
        return User
                .builder()
                .id(userDtoResponse.getId())
                .firstName(userDtoResponse.getFirstName())
                .secondName(userDtoResponse.getSecondName())
                .username(userDtoResponse.getUsername())
                .address(userDtoResponse.getAddress())
                .email(userDtoResponse.getEmail())
                .image(userDtoResponse.getImage())
                .phoneNumber(userDtoResponse.getPhoneNumber())
                .questionsAskedIds(userDtoResponse.getQuestionsAskedIds())
                .answerIds(userDtoResponse.getAnswerIds())
                .build();
    }

    //Question
    public QuestionDtoResponse toResponseModel(QuestionDtoRequest questionDtoRequest) {
        return QuestionDtoResponse
                .builder()
                .id(questionDtoRequest.getId())
                .title(questionDtoRequest.getTitle())
                .description(questionDtoRequest.getDescription())
                .dateAsked(questionDtoRequest.getDateAsked())
                .isResolved(questionDtoRequest.getIsResolved())
                .topics(questionDtoRequest.getTopics())
                .answerIds(questionDtoRequest.getAnswerIds())
                .questionerId(questionDtoRequest.getQuestionerId())
                .build();
    }

    public QuestionDtoResponse toResponseModel(Question question) {
        return QuestionDtoResponse
                .builder()
                .id(question.getId())
                .title(question.getTitle())
                .description(question.getDescription())
                .dateAsked(question.getDateAsked())
                .isResolved(question.getIsResolved())
                .topics(question.getTopics())
                .answerIds(question.getAnswerIds())
                .questionerId(question.getQuestionerId())
                .build();
    }

    public Question toEntity(QuestionDtoResponse questionDtoResponse) {
        return Question
                .builder()
                .id(questionDtoResponse.getId())
                .title(questionDtoResponse.getTitle())
                .description(questionDtoResponse.getDescription())
                .dateAsked(questionDtoResponse.getDateAsked())
                .isResolved(questionDtoResponse.getIsResolved())
                .topics(questionDtoResponse.getTopics())
                .answerIds(questionDtoResponse.getAnswerIds())
                .questionerId(questionDtoResponse.getQuestionerId())
                .build();
    }

    //Answer
    public AnswerDtoResponse toResponseModel(AnswerDtoRequest answerDtoRequest) {
        return AnswerDtoResponse
                .builder()
                .id(answerDtoRequest.getId())
                .dateAnswered(answerDtoRequest.getDateAnswered())
                .title(answerDtoRequest.getTitle())
                .body(answerDtoRequest.getBody())
                .totalUpvotes(answerDtoRequest.getTotalUpvotes())
                .userId(answerDtoRequest.getUserId())
                .questionId(answerDtoRequest.getQuestionId())
                .build();
    }

    public AnswerDtoResponse toResponseModel(Answer answer) {
        return AnswerDtoResponse
                .builder()
                .id(answer.getId())
                .dateAnswered(answer.getDateAnswered())
                .title(answer.getTitle())
                .body(answer.getBody())
                .totalUpvotes(answer.getTotalUpvotes())
                .userId(answer.getUserId())
                .questionId(answer.getQuestionId())
                .build();
    }

    public Answer toEntity(AnswerDtoResponse answerDtoResponse) {
        return Answer
                .builder()
                .id(answerDtoResponse.getId())
                .dateAnswered(answerDtoResponse.getDateAnswered())
                .title(answerDtoResponse.getTitle())
                .body(answerDtoResponse.getBody())
                .totalUpvotes(answerDtoResponse.getTotalUpvotes())
                .userId(answerDtoResponse.getUserId())
                .questionId(answerDtoResponse.getQuestionId())
                .build();
    }
}
