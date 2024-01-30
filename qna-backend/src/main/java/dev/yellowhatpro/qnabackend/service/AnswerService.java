package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.dto.AnswerDto;
import org.bson.types.ObjectId;

import java.util.List;

public interface AnswerService {

    //Create Answer
    AnswerDto createAnswer(AnswerDto answer);

    //Get Answer by id
    AnswerDto getAnswerById(ObjectId answerId);

    //Update Answer
    AnswerDto updateAnswer(AnswerDto answer);

    //Delete Answer
    void deleteAnswerById(ObjectId answerId);

}