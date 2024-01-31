package dev.yellowhatpro.qnabackend.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuestionDtoResponse {
    private String id;
    private String title;
    private String description;
    private String dateAsked;
    private Boolean isResolved;
    private List<String> topics;
    private List<String> answerIds;
    private String questionerId;
}