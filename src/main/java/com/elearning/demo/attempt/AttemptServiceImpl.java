package com.elearning.demo.attempt;

import com.elearning.demo.assumption.Assumption;
import com.elearning.demo.question.Question;
import com.elearning.demo.user_answer.UserAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AttemptServiceImpl implements AttemptService {
    @Autowired
    AttemptRepository attemptRepository;

    @Override
    public List<Attempt> findAllAttempts() {
        return attemptRepository.findAll();
    }

    @Override
    public Attempt saveAttempt(Attempt attempt) {
        return attemptRepository.save(attempt);
    }

    @Override
    public Attempt findAttemptById(Long id) {
        return attemptRepository.findById(id).orElse(null);
    }

    @Override
    public void removeAttempt(Long id) {
        attemptRepository.deleteById(id);
    }



    // Check score
    public long countAverageScore(Attempt attempt) {
        Boolean[] results = attemptBooleanArrayConverter(attempt);
        long countAnswerIsTrue = Arrays.stream(results).filter(value -> value == true).count();
        double score = Math.ceil(((10 / results.length) * countAnswerIsTrue) * 100) / 100;
        return (long) score;
    }

    //Check isCorrect status assumption
    public Boolean checkAnswer(Assumption assumption) {
        Boolean[] assumptionBoolean = assumptionBooleanArrayConverter(assumption);
        Boolean[] questionBoolean = questionBooleanArrayConverter(assumption.getQuestion());
        return Arrays.equals(assumptionBoolean, questionBoolean);
    }

    //Convert Assumption Result into BooleanArray
    public Boolean[] assumptionBooleanArrayConverter(Assumption assumption) {
        Boolean[] answers = new Boolean[assumption.getUserAnswers().size()];
        for (int i = 0; i < assumption.getUserAnswers().size(); i++) {
            answers[i] = assumption.getUserAnswers().get(i).getCorrectAnswer();
        }
        return  answers;
    }

    //Convert Question Result into BooleanArray
    public Boolean[] questionBooleanArrayConverter(Question question) {
        Boolean[] answers = new Boolean[question.getQuestionAnswers().size()];
        for (int i = 0; i < question.getQuestionAnswers().size(); i++) {
            answers[i] = question.getQuestionAnswers().get(i).getIsCorrect();
        }
        return  answers;
    }

    //ConvertAttemptResult into BooleanArray
    public Boolean[] attemptBooleanArrayConverter(Attempt attempt) {
        Boolean[] results = new Boolean[attempt.getAssumptions().size()];
        System.out.println(attempt.getAssumptions().size());
        for (int i = 0; i < attempt.getAssumptions().size(); i++) {
            results[i] = checkAnswer(attempt.getAssumptions().get(i));
        }
        return  results;
    }
}
