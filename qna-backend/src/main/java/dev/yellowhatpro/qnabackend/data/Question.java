package dev.yellowhatpro.qnabackend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private String dateAsked;
    private Boolean isResolved;
    private List<String> topics;
    @DocumentReference
    private List<Answer> answerIds;

    public Question(String title, String description, String dateAsked, Boolean isResolved) {
        this.title = title;
        this.description = description;
        this.dateAsked = dateAsked;
        this.isResolved = isResolved;
    }
}
