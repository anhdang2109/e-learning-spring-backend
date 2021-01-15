package com.elearning.demo.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/admin/questions")
    public List<Question> questions() {return questionService.findAllQuestion();}

    @GetMapping("/admin/questions/{id}")
    public Question findQuestionById(@PathVariable(value = "id") Long id) { return questionService.findQuestionById(id); }

    @PostMapping("/admin/questions")
    public void saveQuestion(@RequestBody Question question) {
        questionService.saveQuestion(question);
    }

    @PutMapping("/admin/questions")
    public void updateQuestion(@RequestBody Question question) { questionService.saveQuestion(question); }

    @DeleteMapping("/admin/questions/{id}")
    public void deleteQuestionById(@PathVariable(value = "id") Long id) {
        questionService.removeQuestion(id);
    }
}
