import { Component, OnInit } from '@angular/core';
import { Location} from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../services/student.service';
import { Student } from "../modal/student";
@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css']
})
export class EditStudentComponent implements OnInit {

    student: Student;
    constructor(
        private location : Location,
        private router: ActivatedRoute,
        private route : Router,
        private studentService: StudentService,
    ) { }

    ngOnInit(): void {
        const id = String(this.router.snapshot.paramMap.get('id'));
        this.studentService.getStudent(id).subscribe( student => this.student = student);
    }

    goBack(): void {
        this.location.back();
    }
    updateStudent(): void {
        const id = String(this.router.snapshot.paramMap.get('id'));
        this.studentService.updateStudent(id, this.student).subscribe(()=> this.route.navigate(['']));

    }

    onSubmit(): void {
        this.updateStudent();
    }





}
