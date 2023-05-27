package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.data.Answer;
import dev.yellowhatpro.qnabackend.data.Question;
import dev.yellowhatpro.qnabackend.repo.QuestionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question createQuestion(String title, String description, String authorId) {
        String dateAsked = Calendar.getInstance().toString();
        Boolean isResolved = false;
        Question question = new Question(title, description, dateAsked, isResolved, authorId);
        questionRepository.insert(question);

        return question;
    }

    public Optional<Question> questionById(ObjectId id) {
        return questionRepository.findById(id);
    }

    public List<Question> allQuestions() {
        return questionRepository.findAll();
    }

    public String markQuestionResolved(ObjectId id) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            question.setIsResolved(true);
            return "ok";
        } else {
            return "wrong";
        }
    }

    public List<Answer> allAnswersOfQuestion(ObjectId id) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        Question question;
        if (questionOptional.isPresent()) {
            question = questionOptional.get();
        } else {
            return Collections.emptyList();
        }
        return question.getAnswerIds();
    }
}
