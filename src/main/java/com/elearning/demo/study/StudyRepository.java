package com.elearning.demo.study;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudyRepository extends PagingAndSortingRepository<Study, Long> {
    @Query(value = "select id from user group by id",nativeQuery = true)
    List<Long> findAllStudy();
}
