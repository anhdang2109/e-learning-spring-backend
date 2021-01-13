package com.elearning.demo.question_answer;

public interface QuestionAnswerService {
    Iterable<QuestionAnswer> findAllQuestionAnswer();
    QuestionAnswer findQuestionAnswerAnswerById(Long id);
    QuestionAnswer saveQuestionAnswer(QuestionAnswer questionAnswer);
    void  removeQuestionAnswer(Long id);
}
