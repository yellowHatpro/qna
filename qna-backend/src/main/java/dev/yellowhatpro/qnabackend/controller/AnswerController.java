package dev.yellowhatpro.qnabackend.controller;

import dev.yellowhatpro.qnabackend.dto.AnswerDtoRequest;
import dev.yellowhatpro.qnabackend.dto.AnswerDtoResponse;
import dev.yellowhatpro.qnabackend.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/find-by-answerId")
    public ResponseEntity<AnswerDtoResponse> answerById(@RequestParam(name = "answerId", required = false) String answerId) {
        AnswerDtoResponse answer = answerService.getAnswerById(answerId);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }
}
