package com.elearning.demo.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyServiceImpl implements StudyService{
    @Autowired
    private StudyRepository studyRepository;

    public List<Study> findAllStudy() {return studyRepository.findAll();}

    public void saveStudy(Study study) {studyRepository.save(study);}

    public Study findStudyById(Long id) {return studyRepository.findById(id).orElse(null);}

    public void removeStudy(Long id) {studyRepository.deleteById(id);}
}
