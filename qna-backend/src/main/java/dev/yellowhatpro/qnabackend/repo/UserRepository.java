package dev.yellowhatpro.qnabackend.repo;

import dev.yellowhatpro.qnabackend.data.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findByUsername(String username);
    Optional<User> findUserById(String userId);
    void deleteUserById(String userId);
    Optional<User> findUserByEmail(String emailId);
}
