package dev.yellowhatpro.qnabackend.controller;

import dev.yellowhatpro.qnabackend.data.Answer;
import dev.yellowhatpro.qnabackend.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping
    public ResponseEntity<Answer> createAnswer(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Answer>(answerService.createAnswer(payload.get("answerBody"), payload.get("questionId"), payload.get("userId")), HttpStatus.CREATED);
    }

    @PostMapping("/upvote")
    public ResponseEntity<String> upvote(@RequestBody Map<String,String> payload){
        return new ResponseEntity<String>(answerService.upvote(payload.get("answerId")), HttpStatus.OK);
    }
}
