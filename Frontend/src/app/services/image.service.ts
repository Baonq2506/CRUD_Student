import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Image } from '../modal/Image';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  private imageUrl="http://localhost:8080/image";
  constructor(
    private http: HttpClient,
  ) { }

  getAllImages(): Observable<Image[]>{
    return this.http.get<Image[]>(this.imageUrl+"/files");
  }
}
