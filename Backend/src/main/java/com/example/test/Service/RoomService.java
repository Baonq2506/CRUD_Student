package com.example.test.Service;

import com.example.test.Model.ClassRoom;
import com.example.test.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;


    public ClassRoom getStudentClass(int classId){
        return roomRepository.getStudentClassById(classId);
    }

    public void deleteStudentFromClassRoom(int studentId){
        roomRepository.deleteStudentFromClassRoom(studentId);
    }

    public List<ClassRoom> getClassRoomAll() {
        return roomRepository.getClassRoom();
    }
}
