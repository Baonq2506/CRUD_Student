import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Student } from '../modal/student';
import { StudentService } from '../services/student.service';

@Component({
  selector: 'app-subject-student',
  templateUrl: './subject-student.component.html',
  styleUrls: ['./subject-student.component.css']
})
export class SubjectStudentComponent implements OnInit {

  student : Student;
  constructor(
    private location : Location,
    private router: ActivatedRoute,
    private studentService: StudentService,
  ) { }

  ngOnInit(): void {
    this.getStudentSubject();
  }

  getStudentSubject(){
    const id =String(this.router.snapshot.paramMap.get('id'));
    this.studentService.getSubjectStudent(id).subscribe(student => this.student = student);
  }

  goBack(){
    this.location.back();
  }
}
