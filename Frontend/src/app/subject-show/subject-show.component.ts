import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subject } from '../modal/Subject';
import { SubjectService } from '../services/subject.service';

@Component({
  selector: 'app-subject-show',
  templateUrl: './subject-show.component.html',
  styleUrls: ['./subject-show.component.css']
})
export class SubjectShowComponent implements OnInit {
    subject: Subject;
    constructor(
        private location : Location,
        private router: ActivatedRoute,
        private subjectService: SubjectService,
    ) { }

    ngOnInit(): void {
        this.getSubjectStudent();
    }

    getSubjectStudent(): void {
        const id = String(this.router.snapshot.paramMap.get('id'));
        this.subjectService.getSubjectStudent(id).subscribe( subject => this.subject = subject);
    }

    goBack(){
        this.location.back();
    }
}
