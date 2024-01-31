package dev.yellowhatpro.qnabackend.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDtoResponse {
    private String id;
    private String firstName;
    private String secondName;
    private String username;
    private String address;
    private String email;
    private String phoneNumber;
    private List<String> questionsAskedIds;
    private List<String> answerIds;
}
