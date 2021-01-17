package com.elearning.demo.question_answer;

import com.elearning.demo.question.Question;
import com.elearning.demo.study.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class QuestionAnswerController {
    @Autowired
    private QuestionAnswerService questionAnswerService;

    @GetMapping("/admin/questionAnswer")
    public List<QuestionAnswer> questionAnswers() {return questionAnswerService.findAllQuestionAnswer();}

    @GetMapping("/admin/questionAnswer/{id}")
    public QuestionAnswer findAllQuestionAnswer(@PathVariable(value = "id") Long id) {
        return questionAnswerService.findQuestionAnswerAnswerById(id);
    }

    @PostMapping("/admin/questionAnswer")
    public void saveStudy(@RequestBody QuestionAnswer questionAnswer) {
        questionAnswerService.saveQuestionAnswer(questionAnswer);
    }

    @PutMapping("/admin/questionAnswer")
    public void updateStudy(@RequestBody QuestionAnswer questionAnswer) { questionAnswerService.saveQuestionAnswer(questionAnswer); }

    @DeleteMapping("/admin/questionAnswer/{id}")
    public void deleteStudy(@PathVariable(value = "id") Long id) {
        questionAnswerService.removeQuestionAnswer(id);
    }

}
