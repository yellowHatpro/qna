package dev.yellowhatpro.qnabackend.controller;

import dev.yellowhatpro.qnabackend.dto.AnswerDtoRequest;
import dev.yellowhatpro.qnabackend.dto.AnswerDtoResponse;
import dev.yellowhatpro.qnabackend.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping
    public ResponseEntity<AnswerDtoResponse> createAnswer(@RequestBody AnswerDtoRequest answerDto){
        AnswerDtoResponse savedAnswer = answerService.createAnswer(answerDto);
        return new ResponseEntity<>(savedAnswer, HttpStatus.CREATED);
    }
}
