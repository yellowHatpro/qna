package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.dto.AnswerDtoRequest;
import dev.yellowhatpro.qnabackend.dto.AnswerDtoResponse;

public interface AnswerService {

    //Create Answer
    AnswerDtoResponse createAnswer(AnswerDtoRequest answer);

    //Get Answer by id
    AnswerDtoResponse getAnswerById(String answerId);

    //Update Answer
    AnswerDtoResponse updateAnswer(AnswerDtoRequest answer);

    //Delete Answer
    void deleteAnswerById(String answerId);

}