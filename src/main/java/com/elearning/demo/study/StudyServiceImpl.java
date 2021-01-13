package com.elearning.demo.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyServiceImpl implements StudyService{
    @Autowired
    private StudyRepository studyRepository;

    @Override
    public List<Study> findAllStudy() {return studyRepository.findAll();}

    @Override
    public Study saveStudy(Study study) {return studyRepository.save(study);}

    @Override
    public Study findStudyById(Long id) {return studyRepository.findById(id).orElse(null);}

    @Override
    public void removeStudy(Long id) {studyRepository.deleteById(id);}
}
