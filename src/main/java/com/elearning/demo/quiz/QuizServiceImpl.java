package com.elearning.demo.quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    QuizRepository quizRepository;

    @Override
    public List<Quiz> findAllQuiz() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz findQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public void removeQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    @Override
    public Long countQuizByCategoryId(Long id) {
        return quizRepository.countQuizByCategoryId(id);
    }
}
