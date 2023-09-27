import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environments';

@Injectable({
  providedIn: 'root'
})
export class FileService {

  constructor(private httpClient: HttpClient) { }


  uploadFile(file: File): Observable<any> {
    const formData: FormData = new FormData();
    formData.append('file', file, file.name);

    return this.httpClient.post(environment.fileUrl, formData);
  }

  downloadFile(fileName: string): Observable<HttpResponse<Blob>> {
    return this.httpClient.get(environment.fileUrl + "/" + fileName, {
      responseType: 'blob',
      observe: 'response'
    });
  }
}
