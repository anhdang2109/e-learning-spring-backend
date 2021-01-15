package com.elearning.demo.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService  {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> findAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question findQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public Question saveQuestion(Question question) { return questionRepository.save(question); }

    @Override
    public void removeQuestion(Long id) { questionRepository.deleteById(id);}
}
