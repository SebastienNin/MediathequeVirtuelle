import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environments';

@Injectable({
  providedIn: 'root'
})
export class SearchHttpService {
 
  constructor(private http: HttpClient) { }

  listAll(): Observable<any> {
    return this.http.get<any>(environment.apiUrl + '/media/');
  }

  search(query: string): Observable<any> {
    // Envoyez la requête de recherche au backend
    return this.http.get<any[]>(environment.apiUrl + "/media/" + query);
  }

  searchByMediaType(query: string): Observable<any> {
    // Envoyez la requête de recherche au backend
    return this.http.get<any[]>(environment.apiUrl + "/media/type/" + query);
  }

  findAllTheme(query: string): Observable<any> {
    return this.http.get<any[]>(environment.apiUrl + "/theme/labelByEnumTheme/" + query);
  }

  // searchByTheme(query: string): Observable<any> {
  //   return this.http.get<any[]>(environment.apiUrl + "/theme/mediaByLabel/" + query);
  // }

  searchByMediaTypeAndTitleContaining(query: string, name: string): Observable<any> {
    // Envoyez la requête de recherche au backend
    return this.http.get<any[]>(environment.apiUrl + "/media/type/" + query + "/nameContaining/" + name);
  }

  searchByTitle(query: string): Observable<any> {
    // return this.http.get<any[]>(environment.apiUrl + "/media/nameContaining/" + query + "/mediaType/" + mediaType);
    return this.http.get<any[]>(environment.apiUrl + "/media/nameContaining/" + query);
  }
  
}