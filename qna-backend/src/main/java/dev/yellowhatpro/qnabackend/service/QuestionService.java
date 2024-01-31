package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.dto.AnswerDtoResponse;
import dev.yellowhatpro.qnabackend.dto.QuestionDtoRequest;
import dev.yellowhatpro.qnabackend.dto.QuestionDtoResponse;

import java.util.List;

public interface QuestionService {
    QuestionDtoResponse createQuestion(QuestionDtoRequest question);
    List<QuestionDtoResponse> getAllQuestions();

    QuestionDtoResponse getQuestionById(String questionId);

    QuestionDtoResponse updateQuestion(QuestionDtoRequest question);

    List<AnswerDtoResponse> getAnswersByQuestionId(String questionId);

    void deleteQuestionById(String questionId);
}
