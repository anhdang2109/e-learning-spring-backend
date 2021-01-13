package com.elearning.demo.question;

public interface QuestionService {
    Iterable<Question> findAllQuestion();
    Question findQuestionById(Long id);
    Question saveQuestion(Question question);
    void  removeQuestion(Long id);
}
