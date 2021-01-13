package com.elearning.demo.user;
import com.elearning.demo.attempt.Attempt;
import com.elearning.demo.group.Group;
import com.elearning.demo.study.Study;
import com.elearning.demo.workplace.Workplace;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private LocalDate created_at;
    private LocalDate updated_at;
    private String status;
    private boolean isAdmin;

    @ManyToOne
    @JoinColumn(name = "workplace_id")
    private Workplace workplace;

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<Study> studies = new ArrayList<>();


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Group> groups;
}
