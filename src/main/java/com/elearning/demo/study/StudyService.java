package com.elearning.demo.study;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface StudyService {
    Iterable<Study> finAll();

    Study save(Study study);

    Optional<Study>findById(Long id);

    void remove(Long id);

    List<Long> findAllStudy();
}
