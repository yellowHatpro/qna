package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.data.Question;
import dev.yellowhatpro.qnabackend.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question createQuestion(String title, String description) {
        String dateAsked = Calendar.getInstance().toString();
        Boolean isResolved = false;
        Question question = new Question(title, description, dateAsked, isResolved);
        questionRepository.insert(question);
        return question;
    }

    public List<Question> allQuestions() {
        return questionRepository.findAll();
    }
}
