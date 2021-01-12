package com.elearning.demo.course;
import com.elearning.demo.quiz.Quiz;
import com.elearning.demo.study.Study;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coursename;
    private String description;



    @OneToMany(mappedBy = "course", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Study> studies = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
