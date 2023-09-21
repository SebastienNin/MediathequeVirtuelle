import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environments';
import { PersonnalizedList } from '../modele/personnalizedList';

@Injectable({
  providedIn: 'root'
})
export class PersoListHttpService {

  constructor(private http: HttpClient) { }


  findAll(): Observable<PersonnalizedList[]> {
    return this.http.get<PersonnalizedList[]>(environment.apiUrl + "/personnalizedlist");
  }

  findById(id: number): Observable<PersonnalizedList> {
    return this.http.get<PersonnalizedList>(environment.apiUrl + "/personnalizedlist/" + id);
  }

  save(personnalizedlist: PersonnalizedList): Observable<PersonnalizedList> {
    if (personnalizedlist.id) { // mise à jour
      return this.http.put<PersonnalizedList>(environment.apiUrl + "/personnalizedlist/" + personnalizedlist.id, personnalizedlist);
    } else { // création
      return this.http.post<PersonnalizedList>(environment.apiUrl + "/personnalizedlist", personnalizedlist);
    }
  }

  deleteById(id: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + "/personnalizedlist/" + id);
  }
}