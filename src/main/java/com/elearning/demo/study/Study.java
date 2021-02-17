package com.elearning.demo.study;
import com.elearning.demo.attempt.Attempt;
import com.elearning.demo.quiz.Quiz;
import com.elearning.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userID;
    private String description;
    private String quizname;
    private String username;
    private String email;
    private Long highestScore;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "study", cascade = CascadeType.MERGE)
    private List<Attempt> attempts = new ArrayList<>();

}
