package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.data.Answer;
import dev.yellowhatpro.qnabackend.data.Question;
import dev.yellowhatpro.qnabackend.data.User;
import dev.yellowhatpro.qnabackend.dto.AnswerDto;
import dev.yellowhatpro.qnabackend.repo.AnswerRepository;
import dev.yellowhatpro.qnabackend.repo.QuestionRepository;
import dev.yellowhatpro.qnabackend.repo.UserRepository;
import dev.yellowhatpro.qnabackend.utils.ModelDtoMapper;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService{

    private AnswerRepository answerRepository;
    private UserRepository userRepository;
    private QuestionRepository questionRepository;

    @Override
    public AnswerDto createAnswer(AnswerDto answerDto) {
        Answer answer = ModelDtoMapper.toAnswer(answerDto);
        Answer savedAnswer = answerRepository.insert(answer);
        User user = userRepository.findById(new ObjectId(answerDto.getUser().getId())).get();
        user.getAnswers().add(answer);
        userRepository.save(user);
        Question question = questionRepository.findById(new ObjectId(answerDto.getQuestion().getId())).get();
        question.getAnswers().add(answer);
        questionRepository.save(question);
        return ModelDtoMapper.toAnswerDto(savedAnswer);
    }

    @Override
    public AnswerDto getAnswerById(ObjectId answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        return ModelDtoMapper.toAnswerDto(optionalAnswer.get());
    }

    @Override
    public AnswerDto updateAnswer(AnswerDto answer) {
        Answer existingAnswer = answerRepository.findById(new ObjectId(answer.getId())).get();
        existingAnswer.setId(new ObjectId(answer.getId()));
        existingAnswer.setTotalUpvotes(answer.getTotalUpvotes());
        existingAnswer.setBody(answer.getBody());
        existingAnswer.setTitle(answer.getTitle());
        existingAnswer.setDateAsked(answer.getDateAsked());
        Answer updatedAnswer = answerRepository.save(existingAnswer);
        return ModelDtoMapper.toAnswerDto(updatedAnswer);
    }

    @Override
    public void deleteAnswerById(ObjectId answerId) {
        answerRepository.deleteById(answerId);
    }
}
