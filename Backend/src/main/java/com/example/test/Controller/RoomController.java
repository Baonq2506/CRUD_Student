package com.example.test.Controller;


import com.example.test.Model.ClassRoom;
import com.example.test.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/{id}")
    public ClassRoom getStudentClass(@PathVariable(value = "id") int id){
        return  roomService.getStudentClass(id);
    }

    @DeleteMapping("/delete/{id}")
    public  void deleteStudentFromClassRoom(@PathVariable (value = "id") int id){
        roomService.deleteStudentFromClassRoom(id);
    }

    @GetMapping("")
    public List<ClassRoom> getClassRoom(){
        return roomService.getClassRoomAll();
    }
}
