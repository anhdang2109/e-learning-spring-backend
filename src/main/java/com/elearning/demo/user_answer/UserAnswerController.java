package com.elearning.demo.user_answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAnswerController {
    @Autowired
    UserAnswerService userAnswerService;

    @GetMapping("/admin/useranswers")
    public List<UserAnswer> findAll() {
        return userAnswerService.findAllUserAnswer();
    }

    @GetMapping("/admin/useranswers/{id}")
    public UserAnswer findUserAnswerById(@PathVariable(value = "id") Long id) {
        return userAnswerService.findUserAnswerById(id);
    }

    @PostMapping("/admin/useranswers")
    public UserAnswer saveUserAnswer(@RequestBody UserAnswer userAnswer) {
        return userAnswerService.saveUserAnswer(userAnswer);
    }

    @PutMapping("/admin/useranswers")
    public void updateUserAnswer(@RequestBody UserAnswer userAnswer) {
        userAnswerService.saveUserAnswer(userAnswer);
    }

    @DeleteMapping("/admin/useranswers/{id}")
    public void deleteUserAnswer(@PathVariable(value = "id") Long id) {
        userAnswerService.removeUserAnswer(id);
    }
}
