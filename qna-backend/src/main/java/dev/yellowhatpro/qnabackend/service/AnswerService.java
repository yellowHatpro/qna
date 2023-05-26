package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.data.Answer;
import dev.yellowhatpro.qnabackend.data.Question;
import dev.yellowhatpro.qnabackend.repo.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Answer createAnswer(String answerBody, String id){
        Answer answer =answerRepository.insert(new Answer(answerBody));

        mongoTemplate.update(Question.class)
                .matching(Criteria.where("id").is(id))
                .apply(new Update().push("answerIds").value(answer))
                .first();
        return answer;
    }
}
