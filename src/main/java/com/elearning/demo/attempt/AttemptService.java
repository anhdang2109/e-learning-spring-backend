package com.elearning.demo.attempt;

import java.util.List;

public interface AttemptService {
    List<Attempt> findAllAttempts();
    Attempt saveAttempt(Attempt attempt);
    Attempt findAttemptById(Long id);
    void removeAttempt(Long id);
}
