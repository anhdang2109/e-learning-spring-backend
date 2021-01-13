package com.elearning.demo.user;

import com.elearning.demo.study.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final String DEFAULT_IMG = "user.jpg";

    @Autowired
    private UserService userService;

    @Autowired
    private StudyService studyService;


    @Value("${upload.path}")
    private String fileUpload;




//    @GetMapping("/admin/users")
//    public List<User> listUsers() {
//        return userService.findAllUser();
//    }
//
//    @PostMapping(value = "/admin/users/create")
//    public User saveUser(@RequestBody User user) {
//        user.setCreated_at(java.time.LocalDate.now());
//        return userService.saveUser(user);
//    }
//
//    @PostMapping(value = "/admin/users/import")
//    public List<User> importUser(@RequestBody List<User> users) {
//        return userService.importUser(users);
//    }
//
//    @GetMapping("/admin/users/view/{id}")
//    public User userView(@PathVariable(value = "id") Long id) {
//        return userService.findUserById(id);
//    }
//
//    @GetMapping("/admin/users/edit/{id}")
//    public User showEditForm(@PathVariable(value = "id") Long id) {
//        return userService.findUserById(id);
//    }
//
//    @PutMapping("/admin/users/edit")
//    public User updateUser(@RequestBody User user) {
//        user.setUpdated_at(java.time.LocalDate.now());
//        return userService.saveUser(user);
//    }
//
//    @DeleteMapping ("/admin/users/delete/{id}")
//    public void deleteUser(@PathVariable(value = "id") Long id) {
//        userService.removeUser(id);
//    }
}
