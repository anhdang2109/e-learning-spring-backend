package com.elearning.demo.user;
import com.elearning.demo.role.Role;
import com.elearning.demo.study.Study;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String gender;
    private String phone;
    private String title;
    private String imageSource;
    private String token;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Integer isDeleted;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<Study> studies = new ArrayList<>();


}
