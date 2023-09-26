import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Media } from './modele/media';
import { environment } from 'src/environments/environments';

@Injectable({
  providedIn: 'root'
})
export class HttpMediaService {

  constructor(private http: HttpClient) {
  }

  //subscribe à faire côté component
  findAll(): Observable<Media[]> {
    return this.http.get<Media[]>(environment.apiUrl + "/media/");
  }

  findById(id: number): Observable<Media> {
    let media: Media;
    //this.http.get<Media>(environment.apiUrl + "/media/" + id);

    return this.http.get<Media>(environment.apiUrl + "/media/" + id);
  }

  save(media: Media) {
    if (media.id) { // Mise à jour
      this.http.put<Media>(environment.apiUrl + "/media/" + media.id, media).subscribe();
    } else { //Création
      console.log(media);
      this.http.post<Media>(environment.apiUrl + "/media/", media).subscribe();
    }
  }

  deleteById(id: number) {
    this.http.delete(environment.apiUrl + "/media/" + id).subscribe();
  }

  uploadFile(fileData: Uint8Array) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/octet-stream' });
    this.http
      .post(environment.apiUrl + '/upload', fileData, { headers, responseType: 'text' })
      .subscribe({
        next: (response) => {
          console.log('Fichier téléchargé avec succès :', response);
        },
        error: (error) => {
          console.log(error);
        },
      });
  }

}