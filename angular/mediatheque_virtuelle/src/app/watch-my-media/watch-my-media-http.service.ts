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

  findAll() : Observable<AccountMedia[]> {
    return this.http.get<AccountMedia[]>(this.apiAccountMediaUrl);
  }

  findAllForAsync() : Observable<AccountMedia[]> {
    return this.http.get<AccountMedia[]>(this.apiAccountMediaUrl);
  }

  findById(id: number) : Observable<AccountMedia> {
    let obs: Observable<AccountMedia> = this.http.get<AccountMedia>(this.apiAccountMediaUrl + "/"+id);

    return obs;
  }

  save()

  deleteById(id: number): Observable<void> {
    return this.http.delete<void>(this.apiAccountMediaUrl + "/"+id);
  }
}
