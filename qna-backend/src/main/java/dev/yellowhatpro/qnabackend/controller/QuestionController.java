package dev.yellowhatpro.qnabackend.controller;

import dev.yellowhatpro.qnabackend.dto.AnswerDto;
import dev.yellowhatpro.qnabackend.dto.QuestionDto;
import dev.yellowhatpro.qnabackend.service.QuestionService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<QuestionDto>> allQuestions() {
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(questionService.getQuestionById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<QuestionDto> createQuestion(@RequestBody QuestionDto questionDto) {
        QuestionDto savedQuestion = questionService.createQuestion(questionDto);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/answers")
    public ResponseEntity<List<AnswerDto>> listAnswers(@PathVariable ObjectId id) {
        List<AnswerDto> listOfAnswers = questionService.getAnswersByQuestionId(id);
        if (!listOfAnswers.isEmpty()) {
            return new ResponseEntity<>(listOfAnswers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}