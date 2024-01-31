package dev.yellowhatpro.qnabackend.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AnswerDtoRequest {
    private String id;
    private String dateAnswered;
    private String title;
    private String body;
    private Integer totalUpvotes;
    private String userId;
    private String questionId;
}
