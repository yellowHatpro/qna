package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.data.Answer;
import dev.yellowhatpro.qnabackend.data.Question;
import dev.yellowhatpro.qnabackend.data.User;
import dev.yellowhatpro.qnabackend.repo.QuestionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Question createQuestion(String title, String description, String userId) {
        String dateAsked = Calendar.getInstance().toString();
        Boolean isResolved = false;
        Question question = new Question(title, description, dateAsked, isResolved);
        questionRepository.insert(question);

        mongoTemplate.update(User.class)
                .matching(Criteria.where("id").is(userId))
                .apply(new Update().set("author", userId))
                .first();
        return question;
    }

    public Optional<Question> questionById(ObjectId id) {
        return questionRepository.findById(id);
    }

    public List<Question> allQuestions() {
        return questionRepository.findAll();
    }

    public void markQuestionResolved(ObjectId id) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            question.setIsResolved(true);
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
