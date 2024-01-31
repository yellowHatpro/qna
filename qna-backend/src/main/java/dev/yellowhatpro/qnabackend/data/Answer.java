package dev.yellowhatpro.qnabackend.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "answers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Answer {
    @Id
    private String id;
    private String dateAnswered;
    private String title;
    private String body;
    private Integer totalUpvotes;
    private String userId;
    private String questionId;
}
