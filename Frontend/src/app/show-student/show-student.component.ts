import { StudentService } from './../services/student.service';
import { Component, Input, OnInit } from '@angular/core';
import { Student } from '../modal/student';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-show-student',
  templateUrl: './show-student.component.html',
  styleUrls: ['./show-student.component.css']
})
export class ShowStudentComponent implements OnInit {
    @Input() student?:Student;

    constructor(
        private studentService: StudentService,
        private location: Location,
        private route : ActivatedRoute,
    ) { }

    ngOnInit(): void {
        this.getStudent();
    }

    getStudent():void{
        const id =String(this.route.snapshot.paramMap.get('id'));
        this.studentService.getStudent(id).subscribe( student => this.student = student);
    }

    goBack(): void {
        this.location.back();
    }

    
}
