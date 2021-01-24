package com.elearning.demo.question;

import com.elearning.demo.assumption.Assumption;
import com.elearning.demo.assumption.AssumptionServiceImpl;
import com.elearning.demo.question_answer.QuestionAnswer;
import com.elearning.demo.question_answer.QuestionAnswerServiceImpl;
import com.elearning.demo.quiz.Quiz;
import com.elearning.demo.quiz.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/admin/question")
public class QuestionController {
    @Autowired
    private QuizServiceImpl quizService;

    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private AssumptionServiceImpl assumptionService;

    @Autowired
    private QuestionAnswerServiceImpl questionAnswerService;

    @GetMapping("/{id}")
    public Question findQuestionById(@PathVariable(value = "id") Long id) {
        return questionService.findQuestionById(id);
    }

    @PostMapping(value = "/searchByCode", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Question> searchQuestionByCode(@RequestBody QuestionSearch search) {
        return questionService.findAllByCodeContaining(search.getCode());
    }

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
    public Question deleteQuestion(@PathVariable("id") Long id) {
        Question question = questionService.findQuestionById(id);
        if (question == null) {
            return null;
        }
        List<Quiz> questionQuizzes = question.getQuizzes();
        if (questionQuizzes.size() != 0) {
            return null;
        }
//        for (Quiz quiz: questionQuizzes) {
//            quiz.getQuestions().removeIf(questionToDelete -> questionToDelete.getId().equals(id));
//            quizService.saveQuiz(quiz);
//        }
        List<Assumption> questionAssumptions = question.getAssumptions();
        for (Assumption assumption: questionAssumptions) {
            assumption.setQuestion(null);
            assumptionService.saveAssumption(assumption);
        }
        List<QuestionAnswer> questionAnswers = question.getQuestionAnswers();
        for (QuestionAnswer questionAnswer: questionAnswers) {
            questionAnswer.setQuestion(null);
            questionAnswerService.saveQuestionAnswer(questionAnswer);
        }
        questionService.removeQuestion(id);
        return question;
    }

    // Update question
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Question editQuestion(@PathVariable Long id, @RequestBody Question question) {
        System.out.println(question);
        System.out.println(question);
        Question updatedQuestion = questionService.saveQuestion(question);
        for (QuestionAnswer answer: question.getQuestionAnswers()) {
            answer.setQuestion(updatedQuestion);
            questionAnswerService.saveQuestionAnswer(answer);
        }
        return updatedQuestion;
    }
}
