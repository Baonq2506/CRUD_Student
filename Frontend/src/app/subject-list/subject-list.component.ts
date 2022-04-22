import { Component, OnInit } from '@angular/core';
import { Subject } from '../modal/Subject';
import { SubjectService } from '../services/subject.service';

@Component({
  selector: 'app-subject-list',
  templateUrl: './subject-list.component.html',
  styleUrls: ['./subject-list.component.css']
})
export class SubjectListComponent implements OnInit {

    subjects:Subject[];
    constructor(
        private subjectService: SubjectService,
    ) { }

    ngOnInit(): void {
        this.getSubjectAll();
    }

    getSubjectAll(){
        this.subjectService.getSubjectAll().subscribe(subjects => this.subjects = subjects);
    }
}
