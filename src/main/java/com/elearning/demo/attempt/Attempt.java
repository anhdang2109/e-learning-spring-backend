package com.elearning.demo.attempt;

import com.elearning.demo.assumption.Assumption;
import com.elearning.demo.question.Question;
import com.elearning.demo.study.Study;
import com.elearning.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "attempt")
@Data
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String username;
    private String email;
    private Long averageScore;
    private LocalDate submittedAt;
    private LocalDate createdAt;
    private Long takingTime;


    @ManyToOne
    @JoinColumn(name = "study_id")
    @JsonIgnore
    private Study study;


    @OneToMany(mappedBy = "attempt")
    private List<Assumption> assumptions;

}
