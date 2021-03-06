package com.elearning.demo.quiz;


import com.elearning.demo.study.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("admin/quizzes")
public class QuizController {
    @Autowired QuizServiceImpl quizService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable allQuiz() {
        return quizService.findAllQuiz();
    }
    // Create quiz
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.saveQuiz(quiz);
    }

    // Delete quiz
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable("id") Long id) {
        Quiz quiz = quizService.findQuizById(id);
        if (quiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        quizService.removeQuiz(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/count/{id}")
    public Long countQuizByCategory(@PathVariable(value = "id") Long id) {return quizService.countQuizByCategoryId(id);}


}
