import { Component, OnInit } from '@angular/core';
import { Class } from '../modal/Class';
import { ClassService } from '../services/class.service';

@Component({
  selector: 'app-room-student',
  templateUrl: './room-student.component.html',
  styleUrls: ['./room-student.component.css']
})
export class RoomStudentComponent implements OnInit {

    classRooms : Class[]=[];
    constructor(
        private classService: ClassService,
    ) { }

    ngOnInit(): void {
        this.getClassRoomAll();
    }

    getClassRoomAll():void {
        this.classService.getClassRoomAll().subscribe( classRooms => this.classRooms = classRooms );
    }
}
