package com.elearning.demo.user;

import com.elearning.demo.role.Role;
import com.elearning.demo.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/users")
public class UserController {

    private final String DEFAULT_IMG = "user.jpg";

    @Autowired
    private RoleService RoleService;

    @Autowired
    private UserService userService;


    @Value("${upload.path}")
    private String fileUpload;

    @Autowired
    PasswordEncoder passwordEncoder;



    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        Role role = RoleService.findRoleByRoleName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(java.time.LocalDate.now());
        //passwordEncoder.encode
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> findAllUser(){
        return new ResponseEntity<>( userService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Optional<User>> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        Optional<User> user1= userService.findById(id);
        if (!user1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        user1.get().setUsername(user.getUsername());
        user1.get().setPassword(user.getPassword());
        user1.get().setEmail(user.getEmail());
        user1.get().setImageSource(user.getImageSource());
        user1.get().setPhone(user.getPhone());
        user1.get().setGender(user.getGender());
        user1.get().setUpdatedAt(java.time.LocalDate.now());

        userService.save(user1.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping ("/delete/{id}")
    public void deleteUser(@PathVariable(value = "id") Long id) {
        userService.restore(id);
    }

}
