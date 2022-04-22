import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ClassService } from '../services/class.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Class } from '../modal/Class';
@Component({
  selector: 'app-show-room',
  templateUrl: './show-room.component.html',
  styleUrls: ['./show-room.component.css']
})
export class ShowRoomComponent implements OnInit {
    classRoom: Class;
    constructor(
        private classService: ClassService,
        private location: Location,
        private router: ActivatedRoute,
    ) { }

    ngOnInit(): void {
        this.getStudentClassRoom();
    }

    getStudentClassRoom(): void {
        const id = String(this.router.snapshot.paramMap.get('id'));
        this.classService.getStudentClassById(id).subscribe(classRoom => this.classRoom = classRoom);
    }

    goBack(): void {
        this.location.back();
    }
}
