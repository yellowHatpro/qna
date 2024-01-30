package dev.yellowhatpro.qnabackend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "users")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;
    private String firstName;
    private String secondName;
    private String username;
    private String address;
    private String email;
    private String phoneNumber;
    @DocumentReference
    private List<Question> questionsAsked;
    @DocumentReference
    private List<Answer> answers;
    @DocumentReference
    private List<User> connections;
}
