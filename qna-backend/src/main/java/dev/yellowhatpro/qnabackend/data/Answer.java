package dev.yellowhatpro.qnabackend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "answers")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    private ObjectId id;
    private String dateAsked;
    private String title;
    private String body;
    private Integer totalUpvotes;
    @DocumentReference
    private User user;
    @DocumentReference
    private Question question;
}
