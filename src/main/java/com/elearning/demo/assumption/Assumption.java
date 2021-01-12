package com.elearning.demo.assumption;

import com.elearning.demo.attempt.Attempt;
import com.elearning.demo.question.Question;
import com.elearning.demo.question_answer.QuestionAnswer;
import com.elearning.demo.user_answer.UserAnswer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "assumption")
@Data
public class Assumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;



    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "attempt_assumption",
            joinColumns = @JoinColumn(name = "assumption_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "attempt_id", referencedColumnName = "id")
    )
    @JsonIgnore
    private List<Attempt> attempts;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany(mappedBy = "assumption", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<UserAnswer> userAnswers = new ArrayList<>();

}
