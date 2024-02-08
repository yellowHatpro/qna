package dev.yellowhatpro.qnabackend.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDtoRequest {
    private String id;
    private String firstName;
    private String secondName;
    private String username;
    private String address;
    private String email;
    private String phoneNumber;
    private String image;
    private List<String> questionsAskedIds;
    private List<String> answerIds;
}
