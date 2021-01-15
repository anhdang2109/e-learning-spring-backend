package com.elearning.demo.attempt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttemptServiceImpl implements AttemptService{
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
}