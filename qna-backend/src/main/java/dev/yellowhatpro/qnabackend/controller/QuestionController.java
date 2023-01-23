package dev.yellowhatpro.qnabackend.controller;

import dev.yellowhatpro.qnabackend.data.Question;
import dev.yellowhatpro.qnabackend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> allQuestions() {
        return new ResponseEntity<List<Question>>(questionService.allQuestions(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Question> createQuestion(@RequestBody Map<String,String> payload){
        return new ResponseEntity<>(questionService.createQuestion(payload.get("title"), payload.get("description") ), HttpStatus.CREATED);
    }
}
