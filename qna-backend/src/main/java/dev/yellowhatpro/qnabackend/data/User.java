package dev.yellowhatpro.qnabackend.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
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
