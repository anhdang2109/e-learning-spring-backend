package com.elearning.demo.question_answer;

import java.util.List;

public interface QuestionAnswerService {
    List<QuestionAnswer> findAllQuestionAnswer();
    QuestionAnswer findQuestionAnswerAnswerById(Long id);
    QuestionAnswer saveQuestionAnswer(QuestionAnswer questionAnswer);
    void  removeQuestionAnswer(Long id);
}
