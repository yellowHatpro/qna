package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.dto.AnswerDto;
import dev.yellowhatpro.qnabackend.dto.QuestionDto;
import org.bson.types.ObjectId;

import java.util.List;

public interface QuestionService {
    QuestionDto createQuestion(QuestionDto question);
    List<QuestionDto> getAllQuestions();

    QuestionDto getQuestionById(ObjectId questionId);

    QuestionDto updateQuestion(QuestionDto question);

    List<AnswerDto> getAnswersByQuestionId(ObjectId questionId);

    void deleteQuestionById(ObjectId questionId);
}
