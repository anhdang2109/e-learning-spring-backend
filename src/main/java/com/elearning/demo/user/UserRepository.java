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
    Iterable<User> findAllByIsDeleted(int isDeleted);
    Page<User> findAllByIsDeleted(int isDeleted, Pageable pageable);

    User findByEmail(String email);
    User findByUsername(String username);
//    User findByUsernameAndIsDeletedFalse(String username);
    User findByUsernameAndIsDeleted(String username, Integer isDeleted);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user u set is_deleted = 1 where u.id = :id", nativeQuery = true)
    void remove(@Param("id") Long id);

    @Query(value="select * from user u where u.username LIKE concat('%',:username,'%') and u.is_deleted = 0",nativeQuery = true)
    Page<User> findAllByNameContaining(@Param("username") String username, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user u set u.is_deleted = 0 where u.id = :id", nativeQuery = true)
    void restore(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user u set u.is_deleted = 1 where u.id = :id", nativeQuery = true)
    void restored(@Param("id") Long id);
}
