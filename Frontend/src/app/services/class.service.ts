import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Class } from '../modal/Class';

@Injectable({
  providedIn: 'root'
})
export class ClassService {
    private classUrl="http://localhost:8080/room/";
    constructor(
        private http: HttpClient,
    ) { }

    getClassRoomAll(): Observable<Class[]>{
        return this.http.get<Class[]>(this.classUrl)
    }

    getStudentClassById(classId: string): Observable<Class>{
        return this.http.get<Class>(this.classUrl+classId);
    }


}
