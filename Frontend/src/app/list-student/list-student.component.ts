import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Student } from '../modal/student';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.css']
})
export class ListStudentComponent implements OnInit {
    students: Student[]=[];
    constructor(
        private studentService: StudentService,

    ) { }

    ngOnInit(): void {
        this.getStudentAll();
    }

    getStudentAll(): void {
        this.studentService.getStudentAll().subscribe( students => {
            console.log(students);
            this.students = students;

        });
    }

    delete(id: string): void {
        this.studentService.deleteStudent(id).subscribe( data => {
            this.getStudentAll();
          });
    }

}
