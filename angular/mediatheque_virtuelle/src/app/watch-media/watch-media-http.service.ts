import { Injectable } from '@angular/core';
import { Media } from '../modele/media';
import { environment } from 'src/environments/environments'; 
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WatchMediaHttpService {

  medias: Array<Media> = new Array<Media>();
  apiMediaUrl: string = environment.apiUrl + "/media/";

  constructor(private http: HttpClient) {}


  findAll() : Observable<Media[]> {
    return this.http.get<Media[]>(this.apiMediaUrl)
  }

  findById(id: number): Observable<Media> {
    let obs: Observable<Media> = this.http.get<Media>(this.apiMediaUrl +id);

  

  deleteById(id: number): Observable<void> {
    return this.http.delete<void>(this.apiMediaUrl +id);
  }
}
