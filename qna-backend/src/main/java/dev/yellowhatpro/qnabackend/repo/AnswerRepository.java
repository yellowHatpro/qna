package dev.yellowhatpro.qnabackend.repo;

import dev.yellowhatpro.qnabackend.data.Answer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends MongoRepository<Answer, ObjectId> {
}
