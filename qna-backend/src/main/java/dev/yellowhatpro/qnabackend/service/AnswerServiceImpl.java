package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.data.Answer;
import dev.yellowhatpro.qnabackend.data.Question;
import dev.yellowhatpro.qnabackend.data.User;
import dev.yellowhatpro.qnabackend.dto.AnswerDtoRequest;
import dev.yellowhatpro.qnabackend.dto.AnswerDtoResponse;
import dev.yellowhatpro.qnabackend.repo.AnswerRepository;
import dev.yellowhatpro.qnabackend.repo.QuestionRepository;
import dev.yellowhatpro.qnabackend.repo.UserRepository;
import dev.yellowhatpro.qnabackend.utils.ModelMapper;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    private ModelMapper modelMapper;

    private AnswerRepository answerRepository;
    private UserRepository userRepository;
    private QuestionRepository questionRepository;

    @Override
    public AnswerDtoResponse createAnswer(AnswerDtoRequest answerDto) {
        AnswerDtoResponse answerDtoResponse = modelMapper.toResponseModel(answerDto);
        Answer savedAnswer = answerRepository.insert(modelMapper.toEntity(answerDtoResponse));
        User user = userRepository.findUserById(answerDto.getUserId()).get();
        user.getAnswerIds().add(answerDto.getId());
        userRepository.save(user);
        Question question = questionRepository.findQuestionById(answerDto.getQuestionId()).get();
        question.getAnswerIds().add(answerDto.getId());
        questionRepository.save(question);
        return modelMapper.toResponseModel(savedAnswer);
    }

    @Override
    public AnswerDtoResponse getAnswerById(String answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findAnswerById(answerId);
        return modelMapper.toResponseModel(optionalAnswer.get());
    }

    @Override
    public AnswerDtoResponse updateAnswer(AnswerDtoRequest answer) {
        Answer existingAnswer = answerRepository.findById(new ObjectId(answer.getId())).get();
        existingAnswer.setId(answer.getId());
        existingAnswer.setTotalUpvotes(answer.getTotalUpvotes());
        existingAnswer.setBody(answer.getBody());
        existingAnswer.setTitle(answer.getTitle());
        existingAnswer.setDateAnswered(answer.getDateAnswered());
        Answer updatedAnswer = answerRepository.save(existingAnswer);
        return modelMapper.toResponseModel(updatedAnswer);
    }

    @Override
    public void deleteAnswerById(String answerId) {
        answerRepository.deleteAnswerById(answerId);
    }
}
