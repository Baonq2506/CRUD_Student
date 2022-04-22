package com.example.test.Repository;

import com.example.test.Model.ClassRoom;
import com.example.test.Model.Profile;
import com.example.test.Model.Student;
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
public class RoomRepository {
    @Autowired
    private JdbcTemplate jdbc;

    public ClassRoom getStudentClassById(int classId){

        String sql ="SELECT s.*,cr.name AS class_name,cr.id as class_id_c FROM CLASS_ROOM cr " +
                "INNER JOIN Student s ON s.class_id = cr.id where cr.id = ? ";
        return jdbc.queryForObject(sql,new Object[]{ classId }, new RowMapper<ClassRoom>() {
            Set<Student> list = new HashSet<>();
            ClassRoom cr = new ClassRoom();
            @Override
            public ClassRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student st = new Student();
                cr.setId(rs.getInt("class_id_c"));
                cr.setName(rs.getString("class_name"));
                list.add(st.getStudent(rs, rowNum,st));

                while(rs.next()) {
                    Student st1 = new Student();
                    list.add( st1.getStudent(rs,rowNum,st1));
                }
                cr.setStudent(list);
                return cr;
            }
        });
    }

    public void deleteStudentFromClassRoom(int studentId){
        String sql="update student set class_id = null where id = ?";
        jdbc.update(sql,studentId);
    }

    public List<ClassRoom> getClassRoom(){
        String sql = "Select * from class_room";
        return jdbc.query(sql, new RowMapper<ClassRoom>() {
            @Override
            public ClassRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
                    ClassRoom cr = new ClassRoom();
                    cr.setId(rs.getInt("id"));
                    cr.setName(rs.getString("name"));
                    return cr;
            }
        });
    }
}
