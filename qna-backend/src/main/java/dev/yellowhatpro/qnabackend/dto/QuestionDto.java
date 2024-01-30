package dev.yellowhatpro.qnabackend.dto;
//
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private String id;
    private String title;
    private String description;
    private String dateAsked;
    private Boolean isResolved;
    private List<String> topics;
    private List<AnswerDto> answers;
    private UserDto questioner;
}