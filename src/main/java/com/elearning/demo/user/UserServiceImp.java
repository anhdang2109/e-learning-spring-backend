package com.elearning.demo.user;


import com.elearning.demo.configuration.model.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Page<User> findAllByNameContaining(String username, Pageable pageable) {
        return userRepository.findAllByNameContaining(username,pageable);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByUserNameAndIsStatusFalse(String username) {
        return userRepository.findByUsernameAndIsDeleted(username,0);
    }

    @Override
    public Page<User> findAllByIsStatusIsTrue(Pageable pageable) {
        return userRepository.findAllByIsDeleted(1, pageable);
    }

    @Override
    public User findByUserNameAndIsStatusIsTrue(String username) {
        return userRepository.findByUsernameAndIsDeleted(username,1);
    }

    @Override
    public void restore(Long id) {
        userRepository.restore(id);
    }

    @Override
    public void restored(Long id) {
        userRepository.restored(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAllByIsDeleted(1);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


    @Override
    public void remove(Long id) {
        userRepository.remove(id);
    }

    @Override
    public Iterable<User> findAllDeleted() {
        return userRepository.findAllByIsDeleted(0);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameAndIsDeleted(username,1);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
//        return null;
        return UserPrinciple.build(user);
    }
}
