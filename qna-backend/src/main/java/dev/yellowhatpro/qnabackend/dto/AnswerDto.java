package dev.yellowhatpro.qnabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {
    private String id;
    private String dateAsked;
    private String title;
    private String body;
    private Integer totalUpvotes;

}
