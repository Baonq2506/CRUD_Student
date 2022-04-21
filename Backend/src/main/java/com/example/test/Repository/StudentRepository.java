package com.example.test.Repository;

import com.example.test.Model.ClassRoom;
import com.example.test.Model.Profile;
import com.example.test.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Student> getStudentAll(){
        String sql="select s.*,p.gender from Student s left join profile p  on p.student_id = s.id";
        return jdbc.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Profile pf = new Profile();
                pf.setGender(rs.getString("gender"));
                Student emp = new Student();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getString("age"));
                emp.setAddress(rs.getString("address"));
                emp.setPhone(rs.getString("phone"));
                emp.setProfile(pf);
                return emp;
            }
        });
    }

    public Student getStudent(String userId){
        String sql = "select s.*,p.gender from Student s left join profile p  on p.student_id = s.id where s.id =? ";
        return jdbc.queryForObject(sql, new Object[]{userId},new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student emp = new Student();
                Profile pf = new Profile();
                pf.setGender(rs.getString("gender"));
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getString("age"));
                emp.setAddress(rs.getString("address"));
                emp.setPhone(rs.getString("phone"));
                emp.setProfile(pf);
                return emp;
            }
        });

    }

    public void create(Student student){
        String  sql = "Insert into student(name,address,phone,age,image) values(?,?,?,?,?)";
       jdbc.update(sql,student.getName(),student.getAddress(),
               student.getPhone(),student.getAge(),student.getImage());
    }

    public void delete(String userId){
        String sql ="DELETE FROM student WHERE id =?";
        jdbc.update(sql,userId);
    }

    public void updateStudent(String id, Student student){

        String sql = "Update Student SET name=?,age=?,address=?,phone=? Where id =? ";
        jdbc.update(sql,student.getName(),student.getAge(),student.getAddress(),
                student.getPhone(),id);
    }

    public List<ClassRoom> getStudentClass(){

        String sql ="SELECT s.*,cr.name AS class_name,cr.id as class_id_c FROM CLASS_ROOM cr " +
                "INNER JOIN Student s ON s.class_id = cr.id ORDER BY cr.id asc";
        return jdbc.query(sql, new RowMapper<ClassRoom>() {
            @Override
            public ClassRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
                ClassRoom cr = new ClassRoom();
                cr.setId(rs.getInt("class_id_c"));
                cr.setName(rs.getString("class_name"));

                Set<Student> list = new HashSet<>();

                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("name"));
                st.setClass_id(rs.getInt("class_id"));

                list.add(st);

                cr.setStudent(list);

                return cr;
            }
        });
    }
}

