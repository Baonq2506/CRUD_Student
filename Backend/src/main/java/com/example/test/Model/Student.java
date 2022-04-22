package com.example.test.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String age;
    private String address;
    private String phone;
    private long class_id;
    @Lob
    private byte[] image;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "class_id",insertable = false ,updatable = false)
    private ClassRoom classRoom;

    @ManyToMany(mappedBy = "students")
    private Collection<Subject> subjects;

    public Student getStudent(ResultSet rs , int row,Student st) throws SQLException {
        st.setId(rs.getInt("id"));
        st.setName(rs.getString("name"));
        st.setAge(rs.getString("age"));
        st.setAddress(rs.getString("address"));
        st.setPhone(rs.getString("phone"));
        st.setClass_id(rs.getInt("class_id"));
        return st;
    }

}
