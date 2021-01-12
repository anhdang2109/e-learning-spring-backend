package com.elearning.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImp {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> importUser(List<User> users) {
        return userRepository.saveAll(users);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

}
