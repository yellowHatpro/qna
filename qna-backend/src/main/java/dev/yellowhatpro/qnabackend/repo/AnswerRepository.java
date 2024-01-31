package dev.yellowhatpro.qnabackend.repo;

import dev.yellowhatpro.qnabackend.data.Answer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerRepository extends MongoRepository<Answer, ObjectId> {
    Optional<Answer> findAnswerById(String id);
    void deleteAnswerById(String id);
}
