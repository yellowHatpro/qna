package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.data.Question;
import dev.yellowhatpro.qnabackend.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    public List<Question> allQuestions(){
        return questionRepository.findAll();
    }
}
