package com.elearning.demo.study;

import java.util.List;

public interface StudyService {
    List<Study> findAllStudy();
    void saveStudy(Study study);
    Study findStudyById(Long id);
    void removeStudy(Long id);
}
