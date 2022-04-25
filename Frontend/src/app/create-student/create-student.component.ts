import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { StudentService } from '../services/student.service';
import { Router } from '@angular/router';
import { Student} from '../modal/student';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { HttpEventType, HttpResponse } from '@angular/common/http';


@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit {

    student : Student = new Student();
    imgURL:any;
    myForm = new FormGroup({
        name: new FormControl('', [Validators.required, Validators.minLength(3)]),
        file: new FormControl('', [Validators.required]),
        fileSource: new FormControl('', [Validators.required])
      });
    constructor(
        private studentService: StudentService,
        private location : Location,
        private route: Router,

    ) { }
    get f(){
        return this.myForm.controls;
      }
    ngOnInit(): void {
    }

    goBack(): void {
        this.location.back();
    }

    saveStudent(){
        this.studentService.create(this.student).subscribe(data => {
            console.log(data);
            this.goToStudentList();
        });
    }

    goToStudentList(){
        this.route.navigate(['']);
    }

    onSubmit(){
        this.saveStudent();
    }

    onFileChange(event:any) {
        const reader = new FileReader();
        if(event.target.files && event.target.files.length) {
            const [file] = event.target.files;
            reader.readAsDataURL(file);
            reader.onload = () => {
                this.imgURL = reader.result as string;
                this.myForm.patchValue({
                fileSource: reader.result
                });
            };
        }
    }




}
