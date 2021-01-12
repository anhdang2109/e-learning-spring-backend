package com.elearning.demo.workplace;

import com.elearning.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Workplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "workplace", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<User> persons;
}
