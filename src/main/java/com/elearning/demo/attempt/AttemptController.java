package com.elearning.demo.attempt;

import com.elearning.demo.assumption.Assumption;
import com.elearning.demo.assumption.AssumptionService;
import com.elearning.demo.user_answer.UserAnswer;
import com.elearning.demo.user_answer.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/attempts")
public class AttemptController {
    @Autowired
    private AttemptService attemptService;

    @Autowired
    private AttemptServiceImpl attemptServiceImpl;

    @Autowired
    private AssumptionService assumptionService;

    @Autowired
    private UserAnswerService userAnswerService;

    @GetMapping
    public List<Attempt> attemptList() {
        return attemptService.findAllAttempts();
    }

    @GetMapping("/{id}")
    public Attempt findAttemptById(@PathVariable(value = "id") Long id) {
        return attemptService.findAttemptById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Attempt saveAttempt(@RequestBody Attempt attempt) {
        System.out.println(attempt.getStudy());
        return attemptService.saveAttempt(attempt);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Attempt updateAttempt(@RequestBody Attempt attempt) {
        Long idAttempt = attempt.getId();
        Attempt attemptExisted = attemptService.findAttemptById(idAttempt);
        attemptExisted.setStatus("finished");
        attemptService.saveAttempt(attemptExisted);
        List<Assumption> assumptions = attempt.getAssumptions();
        for (Assumption assumptionEdited:assumptions) {
            Long idAssumption =  assumptionEdited.getId();
            Assumption assumptionExisted = assumptionService.findAssumptionById(idAssumption);
            assumptionExisted.setStatus("answered");
            assumptionExisted.setGuessNumber(assumptionEdited.getGuessNumber());
            assumptionService.saveAssumption(assumptionExisted);
            List<UserAnswer> userAnswers = assumptionEdited.getUserAnswers();
            for (UserAnswer userAnswer: userAnswers){
                Long idUserAnswer = userAnswer.getId();
                UserAnswer userAnswerExisted = userAnswerService.findUserAnswerById(idUserAnswer);
                userAnswerExisted.setCorrectAnswer(userAnswer.getCorrectAnswer());
                userAnswerExisted.setContent(userAnswer.getContent());
                userAnswerService.saveUserAnswer(userAnswerExisted);
            }
        }
        attemptExisted = attemptService.findAttemptById(idAttempt);
        double testnumber = attemptServiceImpl.countAverageScore(attemptService.findAttemptById(idAttempt));
        attemptExisted.setAverageScore(attemptServiceImpl.countAverageScore(attemptService.findAttemptById(idAttempt)));
        return attemptService.saveAttempt(attemptExisted);
    }

    @DeleteMapping("/{id}")
    public void deleteAttempt(@PathVariable(value = "id") Long id) {
        attemptService.removeAttempt(id);
    }
}
