import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Media } from '../modele/media';
import { environment } from 'src/environments/environments';

@Injectable({
  providedIn: 'root'
})
export class HttpMediaService {

  //medias: Array<Media> = new Array<Media>;

  constructor(private http: HttpClient) {
    //this.load();
   }

//Peut-être pas à garder partout, à voir, en attendant
// load() {
//   this.http.get<Media[]>(environment.apiUrl + "/media").subscribe(resp => this.medias =resp);
// }

save(media : Media) {
  if (media.id) { // Mise à jour
    this.http.put<Media>(environment.apiUrl+"/media/"+media.id, media);
  } else { //Création
    console.log(media);
    this.http.post<Media>(environment.apiUrl+"/media/", media);
  }
}

deleteById(id: number) {

}

}