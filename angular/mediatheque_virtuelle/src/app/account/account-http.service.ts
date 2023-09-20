import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from '../modele/account';

@Injectable({
  providedIn: 'root'
})
export class AccountHttpService {
  constructor(private http: HttpClient) { }


  findAll(): Observable<Account[]> {
    return this.http.get<Account[]>("http://localhost:8080/api/account/");
  }

  findById(id: number): Observable<Account> {
    return this.http.get<Account>("http://localhost:8080/api/account/" + id);
  }

  save(user: Account): Observable<Account> {
    if (user.id) { // mise à jour
      return this.http.put<Account>("http://localhost:8080/api/account/" + user.id, user);
    } else { // création
      return this.http.post<Account>("http://localhost:8080/api/account", user);
    }
  }

  deleteById(id: number): Observable<void> {
    return this.http.delete<void>("http://localhost:8080/api/account/" + id);
  }

  inscription(login: string, password: string, passwordVerif: string): Observable<any> {
    return this.http.post<any>("http://localhost:8080/api/account", {
      "usernloginame": login,
      "password": password,
      "passwordVerif": passwordVerif
    });
  }

  connexion(login: string, password: string): Observable<Account> {
    return this.http.post<Account>("http://localhost:8080/api/account/authentification", {
      "login": login,
      "password": password
    });
  }
}
