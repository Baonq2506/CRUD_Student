package com.example.test.Service;

import com.example.test.Exception.GlobalExceptionHandler;
import com.example.test.Model.ClassRoom;
import com.example.test.Model.Student;
import com.example.test.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public Student getStudentByID(String userId){
        return studentRepository.getStudent(userId) ;
    };

    public void create(Student student){
        studentRepository.create(student);
    };

    public List<Student> getStudentAll(){
        return studentRepository.getStudentAll();
    }

    public void updateStudent(String id ,Student student){
        studentRepository.updateStudent(id,student);
    }

    public void deleteStudentByID(String id){
        studentRepository.delete(id);
    }

    public Student getStudentSubject(String id){
        return studentRepository.getStudentSubject(id);
    }
}
