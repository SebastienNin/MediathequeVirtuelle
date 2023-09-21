import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from '../modele/account';
import { environment } from 'src/environments/environments';


@Injectable({
  providedIn: 'root'
})
export class AccountHttpService {
  constructor(private http: HttpClient) { }


  findAll(): Observable<Account[]> {
    return this.http.get<Account[]>(environment.apiUrl + "/account");
  }

  findById(id: number): Observable<Account> {
    return this.http.get<Account>(environment.apiUrl + "/account/" + id);
  }

  save(user: Account): Observable<Account> {
    if (user.id) { // mise à jour
      return this.http.put<Account>(environment.apiUrl + "/account/" + user.id, user);
    } else { // création
      return this.http.post<Account>(environment.apiUrl + "/account", user);
    }
  }

  deleteById(id: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + "/account/" + id);
  }

  signin(login: string, password: string, passwordVerif: string, name: string, firstName: string, mail: string): Observable<any> {
    return this.http.post<any>(environment.apiUrl + "/account", {
      "login": login,
      "password": password,
      "passwordVerif": passwordVerif,
      "name": name,
      "firstName": firstName,
      "mail": mail
    });
  }

  connection(login: string, password: string): Observable<Account> {
    return this.http.post<Account>(environment.apiUrl + "/account/authentification", {
      "login": login,
      "password": password
    });
  }
}
