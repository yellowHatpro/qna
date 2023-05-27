package dev.yellowhatpro.qnabackend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "answers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    private ObjectId id;
    private String dateAsked;
    private String body;
    private String answererId;
    @DocumentReference
    private List<User> upvoters;
    @DocumentReference
    private List<User> downvoters;


    public Answer(String body, String answererId) {
        this.body = body;
        this.answererId =  answererId;
    }
}
