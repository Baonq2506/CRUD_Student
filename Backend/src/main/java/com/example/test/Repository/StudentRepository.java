package com.example.test.Repository;

import com.example.test.Model.ClassRoom;
import com.example.test.Model.Profile;
import com.example.test.Model.Student;
import com.example.test.Model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

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
                emp.setImage(decompressBytes(rs.getBytes("image")));
                emp.setProfile(pf);
                return emp;
            }
        });

    }

    public void create(Student student) {
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

    public Student getStudentSubject(String id){
        String sql= "SELECT st.name,st.id,s.id as subject_id,s.name as subject_name FROM student st\n" +
                "INNER JOIN STUDENT_SUBJECT ss  ON ss.STUDENT_ID =st.ID \n" +
                "INNER JOIN SUBJECT s ON s.ID = ss.SUBJECT_ID \n" +
                "WHERE st.id =?";
        return jdbc.queryForObject(sql, new Object[]{id}, new RowMapper<Student>() {
            Student s = new Student();
            Collection<Subject> list = new HashSet<>();
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                s.setName(rs.getString("name"));
                s.setId(rs.getInt("id"));
                Subject sj = new Subject();
                sj.setName(rs.getString("subject_name"));
                sj.setId(rs.getInt("subject_id"));
                list.add(sj);
                while(rs.next()){
                    Subject sj2 = new Subject();
                    sj2.setName(rs.getString("subject_name"));
                    sj2.setId(rs.getInt("subject_id"));
                    list.add(sj2);
                }
                s.setSubjects(list);
                return s;
            }
        });
    }


    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
        int count = deflater.deflate(buffer);
        outputStream.write(buffer, 0, count);
        }
        try {
        outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

        // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
        while (!inflater.finished()) {
        int count = inflater.inflate(buffer);
        outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
    return outputStream.toByteArray();
    }

}

