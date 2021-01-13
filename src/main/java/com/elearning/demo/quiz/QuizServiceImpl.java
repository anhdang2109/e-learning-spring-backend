package com.elearning.demo.quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    QuizRepository quizRepository;

    @Override
    public Iterable<Quiz> findAllQuiz() {
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
}
