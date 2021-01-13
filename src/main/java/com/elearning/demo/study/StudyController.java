package com.elearning.demo.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudyController {
    @Autowired
    private StudyService studyService;

    @GetMapping("/admin/studies")
    public List<Study> studyList() {return studyService.findAllStudy();}

    @PostMapping("/admin/studies")
    public void saveStudy(@RequestBody Study study) {
        studyService.saveStudy(study);
    }

    @GetMapping("/admin/studies/{id}")
    public Study findStudyById(@PathVariable(value = "id") Long id) {
        return studyService.findStudyById(id);
    }

    @DeleteMapping("/admin/studies/{id}")
    public void deleteStudy(@PathVariable(value = "id") Long id) {
        studyService.removeStudy(id);
    }
}