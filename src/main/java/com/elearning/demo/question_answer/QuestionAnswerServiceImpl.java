package com.elearning.demo.question_answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;
    @Override
    public Iterable<QuestionAnswer> findAllQuestionAnswer() {
        return questionAnswerRepository.findAll();
    }

    @Override
    public QuestionAnswer findQuestionAnswerAnswerById(Long id) {
        return questionAnswerRepository.findById(id).orElse(null);
    }

    @Override
    public QuestionAnswer saveQuestionAnswer(QuestionAnswer questionAnswer) {
        return questionAnswerRepository.save(questionAnswer);
    }

    @Override
    public void removeQuestionAnswer(Long id) {
        questionAnswerRepository.deleteById(id);

    }
}
