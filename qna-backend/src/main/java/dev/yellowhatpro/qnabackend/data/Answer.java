package dev.yellowhatpro.qnabackend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "answers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    private ObjectId id;
    private String body;
}
