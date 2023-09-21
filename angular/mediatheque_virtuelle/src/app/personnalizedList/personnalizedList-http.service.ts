import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environments';
import { PersonnalizedList } from '../modele/personnalizedList';

@Injectable({
  providedIn: 'root'
})
export class PersonnalizedListHttpService {

  constructor(private http: HttpClient) { }


  findAll(): Observable<PersonnalizedList[]> {
    return this.http.get<PersonnalizedList[]>(environment.apiUrl + "/personnalizedList");
  }

  findById(id: number): Observable<PersonnalizedList> {
    return this.http.get<PersonnalizedList>(environment.apiUrl + "/personnalizedList/" + id);
  }

  save(personnalizedList: PersonnalizedList): Observable<PersonnalizedList> {
    if (personnalizedList.id) { // mise à jour
      return this.http.put<PersonnalizedList>(environment.apiUrl + "/personnalizedList/" + personnalizedList.id, personnalizedList);
    } else { // création
      return this.http.post<PersonnalizedList>(environment.apiUrl + "/personnalizedList", personnalizedList);
    }
  }

  deleteById(id: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + "/personnalizedList/" + id);
  }
}