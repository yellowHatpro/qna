package dev.yellowhatpro.qnabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String id;
    private String firstName;
    private String secondName;
    private String username;
    private String address;
    private String email;
    private String phoneNumber;
    private List<QuestionDto> questionsAsked;
    private List<AnswerDto> answers;
    private List<UserDto> connections;
}
