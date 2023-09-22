import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environments';

@Injectable({
  providedIn: 'root'
})
export class SearchHttpService {
  constructor(private http: HttpClient) { }

  // search(query: string): Observable<any> {
  //   // Envoyez la requête de recherche au backend
  //   return this.http.get<any[]>(environment.apiUrl + "/media/" + query);
  // }

  // searchByTitle(query: string): Observable<any> {
  //   if (!query) {
  //     return this.http.get<any[]>(environment.apiUrl + "/media/");
  //   } else {
  //     return this.http.get<any[]>(environment.apiUrl + "/media/nameContaining/" + query);
  //   }
  // }

  searchByTitleAndType(query: string, mediaType: string): Observable<any> {
    // return this.http.get<any[]>(environment.apiUrl + "/media/nameContaining/" + query + "/mediaType/" + mediaType);
    return this.http.get<any[]>(environment.apiUrl + "/media/nameContaining/" + query);
  }
}