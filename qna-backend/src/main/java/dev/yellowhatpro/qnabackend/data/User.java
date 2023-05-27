package dev.yellowhatpro.qnabackend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;
    private String firstName;
    private String secondName;
    private String username;
    private String specialTitle;
    private String address;
    private String githubUsername;
    private String email;
    private String phoneNumber;
    @DocumentReference
    private List<Question> questionsAsked;
    @DocumentReference
    private List<Answer> answers;
    @DocumentReference
    private List<User> connections;

    public User(String firstName, String secondName, String username, String address, String githubUsername, String email, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.address = address;
        this.githubUsername = githubUsername;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
