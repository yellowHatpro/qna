package dev.yellowhatpro.qnabackend.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question {
    @Id
    private String id;
    private String title;
    private String description;
    private String dateAsked;
    private Boolean isResolved;
    private List<String> topics;
    private List<String> answerIds;
    private String questionerId;
}
