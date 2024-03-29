package dev.yellowhatpro.qnabackend.repo;

import dev.yellowhatpro.qnabackend.data.Question;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends MongoRepository<Question, ObjectId> {
    Optional<Question> findQuestionById(String id);
    void deleteQuestionById(String id);
}