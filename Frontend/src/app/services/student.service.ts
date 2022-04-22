import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from '../modal/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
    private apiUrl ="http://localhost:8080/";
    constructor(
        private httpClient:HttpClient,
    ) { }
    getStudentAll(): Observable<Student[]> {
        return this.httpClient.get<Student[]>(this.apiUrl);
    }

    getStudent(id:String): Observable<Student>{
        return this.httpClient.get<Student>(this.apiUrl+"student/"+id)
    }

    create(student :Student) : Observable<Object>{
        return this.httpClient.post(`${this.apiUrl}`+"student",student);
    }

    deleteStudent(id :string) : Observable<Object>{
        return this.httpClient.delete(this.apiUrl+"student/"+id);
    }

    updateStudent(id :string,student:Student) : Observable<Object>{
        return this.httpClient.put(this.apiUrl+"student/"+id,student);
    }

    getSubjectStudent(id :string): Observable<Student>{
        return this.httpClient.get<Student>(this.apiUrl+"student/subject/"+id);
    }

}
