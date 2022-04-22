package com.example.test.Controller;

import com.example.test.Model.Subject;
import com.example.test.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("subject/")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("")
    public List<Subject> getSubjectAll(){
        return subjectService.getSubjectAll();
    }

    @GetMapping("list/{id}")
    public  Subject getSubjectStudentById(@PathVariable (value = "id") String id){
        return subjectService.getSubjectStudent(id);
    }
}
