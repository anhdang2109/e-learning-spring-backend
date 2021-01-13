package com.elearning.demo.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudyServiceImp implements StudyService {
    @Autowired
    StudyRepository studyRepository;

    @Override
    public Iterable<Study> finAll() {
        return studyRepository.findAll();
    }

    @Override
    public Study save(Study study) {
        return studyRepository.save(study);
    }

    @Override
    public Optional<Study> findById(Long id) {
        return studyRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        studyRepository.deleteById(id);
    }

    @Override
    public List<Long> findAllStudy() {
        return studyRepository.findAllStudy();
    }
}
