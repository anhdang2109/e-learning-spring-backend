package com.elearning.demo.exam;
import com.elearning.demo.quiz.Quiz;
import com.elearning.demo.study.Study;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exam")
@Data
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;



    @OneToMany(mappedBy = "exam", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Study> studies = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
