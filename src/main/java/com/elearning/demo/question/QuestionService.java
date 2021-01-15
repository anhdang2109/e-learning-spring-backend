package com.elearning.demo.question;

import java.util.List;

public interface QuestionService {
    List<Question> findAllQuestion();
    Question findQuestionById(Long id);
    Question saveQuestion(Question question);
    void removeQuestion(Long id);
}
