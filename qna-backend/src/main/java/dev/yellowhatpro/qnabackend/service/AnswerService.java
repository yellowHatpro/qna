package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.data.Answer;
import dev.yellowhatpro.qnabackend.data.Question;
import dev.yellowhatpro.qnabackend.repo.AnswerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Answer createAnswer(String answerBody, String questionId, String answererId){
        Answer answer =answerRepository.insert(new Answer(answerBody, answererId));

        mongoTemplate.update(Question.class)
                .matching(Criteria.where("id").is(questionId))
                .apply(new Update().push("answerIds").value(answer))
                .first();
        return answer;
    }

    public void upVote(String answerId){
        mongoTemplate.update(Answer.class)
                .matching(Criteria.where("id").is(answerId))
                .apply(new Update().inc("totalUpvotes", 1))
                .first();
    }

    public Optional<Answer> getAnswerById(ObjectId answerId) { return answerRepository.findById(answerId); }
}