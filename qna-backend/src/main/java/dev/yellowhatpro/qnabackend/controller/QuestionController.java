package dev.yellowhatpro.qnabackend.controller;

import dev.yellowhatpro.qnabackend.data.Answer;
import dev.yellowhatpro.qnabackend.data.Question;
import dev.yellowhatpro.qnabackend.service.QuestionService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> allQuestions() {
        return new ResponseEntity<List<Question>>(questionService.allQuestions(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable ObjectId id) {
        return new ResponseEntity<>(questionService.questionById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Question> createQuestion(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(questionService.createQuestion(payload.get("title"), payload.get("description"), payload.get("authorId")), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/answers")
    public ResponseEntity<List<Answer>> listAnswers(@PathVariable ObjectId id) {
        List<Answer> listOfAnswers = questionService.allAnswersOfQuestion(id);
        if (!listOfAnswers.isEmpty()) {
            return new ResponseEntity<>(listOfAnswers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/isAnswered")
    public ResponseEntity<String> setAnswered(@PathVariable ObjectId id) {
        String questionOptional = questionService.markQuestionResolved(id);
        if (Objects.equals(questionOptional, "ok")) {
            return new ResponseEntity<>("Question Marked Solved Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something Went Wrong!", HttpStatus.NOT_FOUND);
        }
    }
}