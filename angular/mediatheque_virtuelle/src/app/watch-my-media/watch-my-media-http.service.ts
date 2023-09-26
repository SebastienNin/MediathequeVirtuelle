import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environments';
import { AccountMedia } from '../modele/accountMedia';

@Injectable({
  providedIn: 'root'
})
export class WatchMyMediaHttpService {

  accountMedias: Array<AccountMedia> = new Array <AccountMedia>();
  apiAccountMediaUrl: string = environment.apiUrl + "/accountmedia/";

  constructor(private http: HttpClient) {
    this.load();
  }

  load(): void {
    let obs: Observable<AccountMedia[]> = this.http.get<AccountMedia[]>(this.apiAccountMediaUrl);

    obs.subscribe(resp => {
      this.accountMedias = resp;
    });
  }

  // findByAccount(id: number): Observable<AccountMedia[]> {
  //   // console.log(this.findByAccount(id));
  //   // return this.findByAccount(id);
  //   let obs: Observable<AccountMedia> = this.http.get<AccountMedia>(this.apiAccountMediaUrl + "/findAccount/" + id);
  //   return obs;
  // }

  findAll(): Observable<AccountMedia[]> {
    return this.http.get<AccountMedia[]>(this.apiAccountMediaUrl);
  }

  findById(id: number) : Observable<AccountMedia> {
    let obs: Observable<AccountMedia> = this.http.get<AccountMedia>(this.apiAccountMediaUrl +id);

    return obs;
  }

  save(accountMedia : AccountMedia): void {
    if(accountMedia.id) {
      this.http.put<AccountMedia>(this.apiAccountMediaUrl + accountMedia.id, accountMedia).subscribe(resp => {
        this.load();
      });
    }
    else {
      this.http.post<AccountMedia>(this.apiAccountMediaUrl, accountMedia).subscribe(resp => {
        this.load();
      });
    }
  }

  deleteById(id: number): void {
    this.http.delete<void>(this.apiAccountMediaUrl +id).subscribe( resp => {
      this.load();
    });
  }
}
