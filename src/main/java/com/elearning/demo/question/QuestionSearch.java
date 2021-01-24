package com.elearning.demo.question;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "question_search")
@Data
public class QuestionSearch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String type;
    private String level;
    private Long categoryID;
}
