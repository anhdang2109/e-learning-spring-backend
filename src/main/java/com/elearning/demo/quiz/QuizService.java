package com.elearning.demo.quiz;


import java.util.List;

public interface QuizService {
    List<Quiz> findAllQuiz();
    Quiz findQuizById(Long id);
    Quiz saveQuiz(Quiz quiz);
    void removeQuiz(Long id);
}
