package com.elearning.demo.user_answer;

import java.util.List;

public interface UserAnswerService {
    List<UserAnswer> findAllUserAnswer();
    UserAnswer saveUserAnswer(UserAnswer userAnswer);
    UserAnswer findUserAnswerById(Long id);
    void removeUserAnswer(Long id);
}
