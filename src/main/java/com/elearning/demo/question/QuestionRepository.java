package com.elearning.demo.question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByCodeContainingOrTypeContainingOrLevelContaining(String code, String type, String level);
    List<Question> findAllByCodeContaining(String code);
}
