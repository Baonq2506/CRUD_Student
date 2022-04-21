package com.example.test.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "profile")
public class Profile {
    @Id
    private long id;
    private String gender;
    private long student_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id",insertable = false,updatable = false)
    private Student student;
}
