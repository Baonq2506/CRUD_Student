import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Subject } from '../modal/Subject';

@Injectable({
  providedIn: 'root'
})
export class SubjectService {
    private subjectUrl="http://localhost:8080/subject/";
    constructor(
        private http: HttpClient,
    ) { }

    getSubjectStudent(id:String):Observable<Subject>{
        return this.http.get<Subject>(this.subjectUrl+"list/"+id);
    }

    getSubjectAll():Observable<Subject[]>{
        return this.http.get<Subject[]>(this.subjectUrl);
    }

}
