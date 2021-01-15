package com.elearning.demo.quiz;

import com.elearning.demo.study.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping("/admin/quizzes")
    public List<Quiz> quizList() { return quizService.findAllQuiz(); }

    @GetMapping("/admin/quizzes/{id}")
    public Quiz findStudyById(@PathVariable(value = "id") Long id) {
        return quizService.findQuizById(id);
    }

    @PostMapping("/admin/quizzes")
    public void saveStudy(@RequestBody Quiz quiz) {
        quizService.saveQuiz(quiz);
    }

    @PutMapping("/admin/quizzes")
    public void updateStudy(@RequestBody Quiz quiz) { quizService.saveQuiz(quiz); }

    @DeleteMapping("/admin/quizzes/{id}")
    public void deleteStudy(@PathVariable(value = "id") Long id) {
        quizService.removeQuiz(id);
    }
}
