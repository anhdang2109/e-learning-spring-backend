package com.elearning.demo.user_answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/useranswers")
public class UserAnswerController {
    @Autowired
    UserAnswerService userAnswerService;

    @GetMapping
    public List<UserAnswer> findAll() {
        return userAnswerService.findAllUserAnswer();
    }

    @GetMapping("/{id}")
    public UserAnswer findUserAnswerById(@PathVariable(value = "id") Long id) {
        return userAnswerService.findUserAnswerById(id);
    }

    @PostMapping
    public UserAnswer saveUserAnswer(@RequestBody UserAnswer userAnswer) {
        return userAnswerService.saveUserAnswer(userAnswer);
    }

    @PutMapping
    public void updateUserAnswer(@RequestBody UserAnswer userAnswer) {
        userAnswerService.saveUserAnswer(userAnswer);
    }

    @DeleteMapping("/{id}")
    public void deleteUserAnswer(@PathVariable(value = "id") Long id) {
        userAnswerService.removeUserAnswer(id);
    }
}
