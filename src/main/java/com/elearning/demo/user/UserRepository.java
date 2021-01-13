package com.elearning.demo.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAllByStatusFalse(Pageable pageable);
    Page<User> findAllByStatusTrue(Pageable pageable);

    User findByUsername(String username);
    User findByUsernameAndStatusIsFalse(String username);
    User findByUsernameAndStatusIsTrue(String username);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user u set status = 1 where u.id = :id", nativeQuery = true)
    void remove(@Param("id") Long id);

    @Query(value="select * from user u where u.username LIKE concat('%',:username,'%') and u.status = 0",nativeQuery = true)
    Page<User> findAllByNameContaining(@Param("username") String username, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user u set u.status = 0 where u.id = :id", nativeQuery = true)
    void restore(@Param("id") Long id);
}
