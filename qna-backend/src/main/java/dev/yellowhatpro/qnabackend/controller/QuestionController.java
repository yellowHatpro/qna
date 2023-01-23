package dev.yellowhatpro.qnabackend.controller;

import dev.yellowhatpro.qnabackend.data.Question;
import dev.yellowhatpro.qnabackend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> allQuestions() {
        return new ResponseEntity<List<Question>>(questionService.allQuestions(), HttpStatus.OK);
    }
}
