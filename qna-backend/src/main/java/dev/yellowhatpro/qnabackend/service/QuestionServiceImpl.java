package dev.yellowhatpro.qnabackend.service;

import dev.yellowhatpro.qnabackend.data.Question;
import dev.yellowhatpro.qnabackend.data.User;
import dev.yellowhatpro.qnabackend.dto.AnswerDtoResponse;
import dev.yellowhatpro.qnabackend.dto.QuestionDtoRequest;
import dev.yellowhatpro.qnabackend.dto.QuestionDtoResponse;
import dev.yellowhatpro.qnabackend.repo.AnswerRepository;
import dev.yellowhatpro.qnabackend.repo.QuestionRepository;
import dev.yellowhatpro.qnabackend.repo.UserRepository;
import dev.yellowhatpro.qnabackend.utils.ModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    private UserRepository userRepository;
    private AnswerRepository answerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuestionDtoResponse createQuestion(QuestionDtoRequest questionDtoRequest) {
        QuestionDtoResponse questionDto = modelMapper.toResponseModel(questionDtoRequest);
        Question question = modelMapper.toEntity(questionDto);
        Question savedQuestion = questionRepository.insert(question);
        User user = userRepository.findUserById(questionDtoRequest.getQuestionerId()).get();
        user.getQuestionsAskedIds().add(question.getId());
        userRepository.save(user);
        return modelMapper.toResponseModel(savedQuestion);
    }

    @Override
    public List<QuestionDtoResponse> getAllQuestions() {
        return questionRepository
                .findAll()
                .stream()
                .map(question -> modelMapper.toResponseModel(question))
                .collect(Collectors.toList());
    }

    @Override
    public QuestionDtoResponse getQuestionById(String questionId) {
        Question question = questionRepository.findQuestionById(questionId).get();
        return modelMapper.toResponseModel(question);
    }

    @Override
    public QuestionDtoResponse updateQuestion(QuestionDtoRequest question) {
        Question existingQuestion = questionRepository.findQuestionById(question.getId()).get();
        existingQuestion.setId(question.getId());
        existingQuestion.setTitle(question.getTitle());
        existingQuestion.setDescription(question.getDescription());
        existingQuestion.setDateAsked(question.getDateAsked());
        existingQuestion.setAnswerIds(question.getAnswerIds());
        existingQuestion.setQuestionerId(question.getQuestionerId());
        existingQuestion.setTopics(question.getTopics());
        Question updatedQuestion = questionRepository.save(existingQuestion);
        return modelMapper.toResponseModel(updatedQuestion);
    }

    @Override
    public List<AnswerDtoResponse> getAnswersByQuestionId(String questionId) {
        List<String>  answerIds = questionRepository
                .findQuestionById(questionId)
                .get()
                .getAnswerIds();
        return answerIds
                .stream()
                .map(id ->
                        modelMapper.toResponseModel(
                                answerRepository
                                        .findAnswerById(id).get())
                ).
                toList();
    }

    @Override
    public void deleteQuestionById(String questionId) {
        questionRepository.deleteQuestionById(questionId);
    }
}
