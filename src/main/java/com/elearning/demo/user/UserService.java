package com.elearning.demo.user;

import com.elearning.demo.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService extends IGeneralService<User>, UserDetailsService {
    Page<User> findAllByNameContaining(String username, Pageable pageable);
    User findByUsername(String username);
    User findByUserNameAndIsStatusFalse(String username);
    Page<User> findAllByIsStatusIsTrue(Pageable pageable);
    User findByUserNameAndIsStatusIsTrue(String username);
    void restore(Long id);
}
