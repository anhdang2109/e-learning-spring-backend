package com.elearning.demo.question_answer;

import com.elearning.demo.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/questionAnswer")
public class QuestionAnswerController {
    @Autowired QuestionAnswerServiceImpl questionAnswerService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable allQuestionAnswer() {
        return questionAnswerService.findAllQuestionAnswer();
    }
    // Create question answer
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public QuestionAnswer createQuestionAnswer(@RequestBody QuestionAnswer questionAnswer) {
        return questionAnswerService.saveQuestionAnswer(questionAnswer);
    }

    // Delete question answer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionAnswer(@PathVariable("id") Long id) {
        QuestionAnswer questionAnswer = questionAnswerService.findQuestionAnswerAnswerById(id);
        if (questionAnswer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        questionAnswerService.removeQuestionAnswer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Update question answer
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public QuestionAnswer editQuestionAnswer(@PathVariable Long id, @RequestBody QuestionAnswer questionAnswer) {
        questionAnswer.setId(id);
        return questionAnswerService.saveQuestionAnswer(questionAnswer);
    }


}
