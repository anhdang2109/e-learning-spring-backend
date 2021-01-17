package com.elearning.demo.study;

import com.elearning.demo.assumption.Assumption;
import com.elearning.demo.assumption.AssumptionService;
import com.elearning.demo.attempt.Attempt;
import com.elearning.demo.attempt.AttemptService;
import com.elearning.demo.question.Question;
import com.elearning.demo.quiz.Quiz;
import com.elearning.demo.user_answer.UserAnswer;
import com.elearning.demo.user_answer.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class StudyController {
    @Autowired
    private StudyService studyService;

    @Autowired
    private AttemptService attemptService;

    @Autowired
    private AssumptionService assumptionService;

    @Autowired
    private UserAnswerService userAnswerService;

    @GetMapping("/admin/studies")
    public List<Study> studyList() {return studyService.findAllStudy();}

    @GetMapping("/admin/studies/{id}")
    public Study findStudyById(@PathVariable(value = "id") Long id) {
        return studyService.findStudyById(id);
    }

    @PostMapping("/admin/studies")
    public void saveStudy(@RequestBody Study study) {
        studyService.saveStudy(study);
    }

    @PutMapping("/admin/studies")
    public void updateStudy(@RequestBody Study study) { studyService.saveStudy(study); }

    @PostMapping("/admin/studies/addAttempt")
    public Attempt addAttempt(@RequestBody Study study) {
        Long idStudy = study.getId();
        Study studyExisted = studyService.findStudyById(idStudy);
        Long idNewAttempt = attemptService.saveAttempt(new Attempt()).getId();
        Attempt newAttempt = attemptService.findAttemptById(idNewAttempt);
        newAttempt.setStudy(studyExisted);
        newAttempt.setStatus("in progress");
        List<Assumption> newAttemptAssumption = new ArrayList<>();
        Quiz studyQuiz = study.getQuiz();
        for (int i = 0; i < studyQuiz.getQuestions().size(); i++) {
            Long idNewAssumption = assumptionService.saveAssumption(new Assumption()).getId();
            Assumption newAssumption = assumptionService.findAssumptionById(idNewAssumption);
            newAssumption.setQuestion(studyQuiz.getQuestions().get(i));
            for (int j = 0; j < 4; j++) {
                Long idNewUserAnswer = userAnswerService.saveUserAnswer(new UserAnswer()).getId();
                UserAnswer newUserAnswer = userAnswerService.findUserAnswerById(idNewUserAnswer);
                newUserAnswer.setContent(studyQuiz.getQuestions().get(i).getQuestionAnswers().get(j).getContent());
                newUserAnswer.setCorrectAnswer(false);
                newUserAnswer.setAssumption(newAssumption);
                userAnswerService.saveUserAnswer(newUserAnswer);
            }
            newAssumption.setAttempt(newAttempt);
            assumptionService.saveAssumption(newAssumption);
        }
        newAttempt.setAssumptions(newAttemptAssumption);
        return attemptService.saveAttempt(newAttempt);
    }

    @DeleteMapping("/admin/studies/{id}")
    public void deleteStudy(@PathVariable(value = "id") Long id) {
        studyService.removeStudy(id);
    }
}
