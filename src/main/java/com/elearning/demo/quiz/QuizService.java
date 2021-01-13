package com.elearning.demo.quiz;


public interface QuizService {
    Iterable<Quiz> findAllQuiz();
    Quiz findQuizById(Long id);
    Quiz saveQuiz(Quiz quiz);
    void  removeQuiz(Long id);
}
