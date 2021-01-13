package com.elearning.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public User findByUserNameAndIsStatusFalse(String username) {
        return userRepository.findByUsernameAndStatusIsFalse(username);
    }

    @Override
    public Page<User> findAllByIsStatusIsTrue(Pageable pageable) {
        return userRepository.findAllByStatusTrue(pageable);
    }

    @Override
    public User findByUserNameAndIsStatusIsTrue(String username) {
        return userRepository.findByUsernameAndStatusIsTrue(username);
    }

    @Override
    public void restore(Long id) {
        userRepository.restore(id);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAllByStatusFalse(pageable);
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameAndStatusIsFalse(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return null;
    }
}
