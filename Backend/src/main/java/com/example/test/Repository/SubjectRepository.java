package com.example.test.Repository;

import com.example.test.Model.ClassRoom;
import com.example.test.Model.Student;
import com.example.test.Model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class SubjectRepository {
    @Autowired
    private JdbcTemplate jdbc;

    public Subject getStudentSubjectById(String subjectId){

        String sql= "SELECT s.*,sj.id as subject_id,sj.name as subject_name FROM subject sj\n" +
                "INNER JOIN STUDENT_SUBJECT ss  ON ss.SUBJECT_ID  =sj.ID \n" +
                "INNER JOIN Student s ON s.ID = ss.student_ID \n" +
                "WHERE sj.id =?";
        return jdbc.queryForObject(sql,new Object[]{ subjectId }, new RowMapper<Subject>() {
            Set<Student> list = new HashSet<>();
            Subject sj = new Subject();
            @Override
            public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student st = new Student();
                sj.setId(rs.getInt("subject_id"));
                sj.setName(rs.getString("subject_name"));
                list.add(st.getStudent(rs, rowNum,st));

                while(rs.next()) {
                    Student st1 = new Student();
                    list.add( st1.getStudent(rs,rowNum,st1));
                }
                sj.setStudents(list);
                return sj;
            }
        });
    }

    public List<Subject> getSubjectAll(){
        String sql = "Select * from subject";
        return jdbc.query(sql, new RowMapper<Subject>() {
            @Override
            public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
                Subject sj = new Subject();
                sj.setId(rs.getInt("id"));
                sj.setName(rs.getString("name"));
                return sj;
            }
        });
    }
}
