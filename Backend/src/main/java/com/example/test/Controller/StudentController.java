package com.example.test.Controller;

import com.example.test.Exception.GlobalExceptionHandler;
import com.example.test.Model.ClassRoom;
import com.example.test.Service.StudentService;
import com.example.test.Model.Student;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;


@CrossOrigin( origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class StudentController {

    private Log log = LogFactory.getLog(StudentController.class);

    @Autowired
    private StudentService studentService;


    @GetMapping("")
    public List<Student> getStudentList(){
        return studentService.getStudentAll();
    }

    @GetMapping("student/{id}")
    public Student getStudent(@PathVariable(value = "id") String  id ){
        return  studentService.getStudentByID(id);

    }

    @PostMapping("student")
    public void createUser(@RequestBody Student student){
       studentService.create(student);

    }

    @DeleteMapping("/student/{id}")
    public void deleteUser(@PathVariable (value = "id") String id){
        studentService.deleteStudentByID(id);
    }

    @PutMapping("student/{id}")
    public  void updateStudent(@PathVariable (value = "id") String id, @RequestBody Student student){
        studentService.updateStudent(id,student);
    }

    @GetMapping("/student/subject/{id}")
    public  Student getStudentSubject(@PathVariable( value = "id") String id){
        return studentService.getStudentSubject(id);
    }


}
