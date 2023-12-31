import { Injectable } from '@angular/core';
import { PersoListJoinMedia } from '../modele/persoListJoinMedia';
import { environment } from 'src/environments/environments';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Account } from '../modele/account';
import { PersonnalizedList } from '../modele/personnalizedList';


@Injectable({
  providedIn: 'root'
})
export class PersoListJoinMediaHttpService {

  constructor(private http: HttpClient) { }


  findAll(): Observable<PersoListJoinMedia[]> {
    return this.http.get<PersoListJoinMedia[]>(environment.apiUrl + "/persoListJoinMedia");
  }

  findById(id: number): Observable<PersoListJoinMedia[]> {
    return this.http.get<PersoListJoinMedia[]>(environment.apiUrl + "/persoListJoinMedia/" + id);
  }

  findByPersoList(persoListId: number): Observable<PersoListJoinMedia[]> {
    return this.http.get<PersoListJoinMedia[]>(environment.apiUrl + "/persoListJoinMedia/persoList/" + persoListId);
  }


  save(mediaId: number, persoListId: number): Observable<PersoListJoinMedia> {

    return this.http.post<PersoListJoinMedia>(environment.apiUrl + "/persoListJoinMedia", {
      "mediaId": mediaId,
      "persoListId": persoListId
    });
  }

  deleteById(id: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + "/persoListJoinMedia/" + id);
  }
}
