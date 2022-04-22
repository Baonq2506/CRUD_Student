package com.example.test.Service;

import com.example.test.Model.ClassRoom;
import com.example.test.Model.Subject;
import com.example.test.Repository.RoomRepository;
import com.example.test.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public Subject getSubjectStudent(String subjectId){
        return subjectRepository.getStudentSubjectById(subjectId);
    }

    public List<Subject> getSubjectAll() {
        return subjectRepository.getSubjectAll();
    }
}
