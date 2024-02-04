package dev.yellowhatpro.qnabackend.controller;

import dev.yellowhatpro.qnabackend.dto.AnswerDtoResponse;
import dev.yellowhatpro.qnabackend.dto.QuestionDtoRequest;
import dev.yellowhatpro.qnabackend.dto.QuestionDtoResponse;
import dev.yellowhatpro.qnabackend.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<QuestionDtoResponse>> allQuestions() {
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDtoResponse> getQuestionById(@PathVariable String id) {
        return new ResponseEntity<>(questionService.getQuestionById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionDtoResponse> createQuestion(@RequestBody QuestionDtoRequest questionDtoRequest) {
        QuestionDtoResponse savedQuestion = questionService.createQuestion(questionDtoRequest);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/answers")
    public ResponseEntity<List<AnswerDtoResponse>> listAnswers(@PathVariable String id) {
        List<AnswerDtoResponse> listOfAnswers = questionService.getAnswersByQuestionId(id);
        if (!listOfAnswers.isEmpty()) {
            return new ResponseEntity<>(listOfAnswers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}