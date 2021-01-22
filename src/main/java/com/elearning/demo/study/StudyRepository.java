package com.elearning.demo.study;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {
    @Query("select s.id from Study s where s.user.id = :userId and s.quiz.id = :quizId")
    Long getStudyId(@Param("userId") Long userId, @Param("quizId") Long quizId);
}
