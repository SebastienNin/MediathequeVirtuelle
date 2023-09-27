import { Injectable } from '@angular/core';
import { PersoListJoinMedia } from '../modele/persoListJoinMedia';
import { environment } from 'src/environments/environments';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersoListJoinMediaHttpService {

  constructor(private http: HttpClient) { }


  findAll(): Observable<PersoListJoinMedia[]> {
    return this.http.get<PersoListJoinMedia[]>(environment.apiUrl + "/persoListJoinMedia");
  }

  findById(id: number): Observable<PersoListJoinMedia> {
    return this.http.get<PersoListJoinMedia>(environment.apiUrl + "/persoListJoinMedia/" + id);
  }

  save(persoListJoinMedia: PersoListJoinMedia): Observable<PersoListJoinMedia> {
    if (persoListJoinMedia.id) {
      return this.http.put<PersoListJoinMedia>(environment.apiUrl + "/persoListJoinMedia/" + persoListJoinMedia.id, persoListJoinMedia);
    } else {
      return this.http.post<PersoListJoinMedia>(environment.apiUrl + "/persoListJoinMedia", persoListJoinMedia);
    }
  }

  deleteById(id: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + "/persoListJoinMedia/" + id);
  }
}
