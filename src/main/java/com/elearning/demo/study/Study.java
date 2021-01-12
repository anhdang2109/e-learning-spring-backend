package com.elearning.demo.study;
import com.elearning.demo.attempt.Attempt;
import com.elearning.demo.course.Course;
import com.elearning.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studyname;
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "study", cascade = CascadeType.MERGE)
    private List<Attempt> attempts = new ArrayList<>();

}
