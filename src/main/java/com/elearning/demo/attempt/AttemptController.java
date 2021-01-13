package com.elearning.demo.attempt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttemptController {
    @Autowired
    private AttemptService attemptService;

    @GetMapping("/admin/attempts")
    public List<Attempt> attemptList() {
        return attemptService.findAllAttempts();
    }

    @GetMapping("admin/attempts/{id}")
    public Attempt findAttemptById(@PathVariable(value = "id") Long id) {
        return attemptService.findAttemptById(id);
    }

    @PostMapping("/admin/attempts")
    public Attempt saveAttempt(@RequestBody Attempt attempt) {
        return attemptService.saveAttempt(attempt);
    }

    @PutMapping("/admin/attempts")
    public void updateAttempt(@RequestBody Attempt attempt) {
        attemptService.saveAttempt(attempt);
    }

    @DeleteMapping("/admin/attempts/{id}")
    public void deleteAttempt(@PathVariable(value = "id") Long id) {
        attemptService.removeAttempt(id);
    }
}
