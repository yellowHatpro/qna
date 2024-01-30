package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.data.Question;
import dev.yellowhatpro.qnabackend.data.User;
import dev.yellowhatpro.qnabackend.dto.AnswerDto;
import dev.yellowhatpro.qnabackend.dto.QuestionDto;
import dev.yellowhatpro.qnabackend.repo.QuestionRepository;
import dev.yellowhatpro.qnabackend.repo.UserRepository;
import dev.yellowhatpro.qnabackend.utils.ModelDtoMapper;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    private UserRepository userRepository;

    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        Question question = ModelDtoMapper.toQuestion(questionDto);
        Question savedQuestion = questionRepository.insert(question);
        User user = userRepository.findById(new ObjectId(questionDto.getQuestioner().getId())).get();
        user.getQuestionsAsked().add(savedQuestion);
        userRepository.save(user);
        return ModelDtoMapper.toQuestionDto(savedQuestion);
    }

    @Override
    public List<QuestionDto> getAllQuestions() {
        return questionRepository
                .findAll()
                .stream()
                .map(ModelDtoMapper::toQuestionDto)
                .toList();
    }

    @Override
    public QuestionDto getQuestionById(ObjectId questionId) {
        Question question = questionRepository.findById(questionId).get();
        return ModelDtoMapper.toQuestionDto(question);
    }

    @Override
    public QuestionDto updateQuestion(QuestionDto question) {
        Question existingQuestion = questionRepository.findById(new ObjectId(question.getId())).get();
        existingQuestion.setId(new ObjectId(question.getId()));
        existingQuestion.setTitle(question.getTitle());
        existingQuestion.setDescription(question.getDescription());
        existingQuestion.setDateAsked(question.getDateAsked());
        existingQuestion.setAnswers(question.getAnswers().stream().map(ModelDtoMapper::toAnswer).collect(Collectors.toList()));
        existingQuestion.setQuestioner(ModelDtoMapper.toUser(question.getQuestioner()));
        existingQuestion.setTopics(question.getTopics());
        Question updatedQuestion = questionRepository.save(existingQuestion);
        return ModelDtoMapper.toQuestionDto(updatedQuestion);
    }

    @Override
    public List<AnswerDto> getAnswersByQuestionId(ObjectId questionId) {
        return questionRepository
                .findById(questionId)
                .get()
                .getAnswers()
                .stream()
                .map(ModelDtoMapper::toAnswerDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteQuestionById(ObjectId questionId) {
        questionRepository.deleteById(questionId);
    }
}
