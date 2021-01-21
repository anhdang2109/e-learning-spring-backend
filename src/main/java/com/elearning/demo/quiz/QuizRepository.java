package com.elearning.demo.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    @Query(value = "select count(category_id) from Quiz s where s.category_id = :id", nativeQuery = true)
    Long countQuizByCategoryId(@Param("id") Long id);

}
