package com.elearning.demo.question;

import com.elearning.demo.question_answer.QuestionAnswer;
import com.elearning.demo.question_answer.QuestionAnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private QuestionAnswerServiceImpl questionAnswerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable allQuestion() {
        return questionService.findAllQuestion();
    }

    // Create question
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Question createQuestion(@RequestBody Question question) {
        Long newQuestionID = questionService.saveQuestion(question).getId();
        for (QuestionAnswer answer: question.getQuestionAnswers()) {
            answer.setQuestion(new Question());
            answer.getQuestion().setId(newQuestionID);
            questionAnswerService.saveQuestionAnswer(answer);
        }
        return question;
    }

    // Delete question
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable("id") Long id) {
        Question question = questionService.findQuestionById(id);
        if (question == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        questionService.removeQuestion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Update question
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Question editQuestion(@PathVariable Long id, @RequestBody Question question) {
        question.setId(id);
        return questionService.saveQuestion(question);
    }


}
