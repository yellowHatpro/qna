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

@Document(collection = "questions")
@Data
@Accessors(chain = true)
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
    private List<Answer> answers;
    @DocumentReference
    private User questioner;

}
