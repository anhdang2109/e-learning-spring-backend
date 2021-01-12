package com.elearning.demo.quiz;

import com.elearning.demo.category.Category;
import com.elearning.demo.question.Question;
import com.elearning.demo.study.Study;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String quizname;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Study> studies = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "quiz_question",
            joinColumns = @JoinColumn(name = "quiz_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id")
    )
    private List<Question> questions = new ArrayList<>();

}
