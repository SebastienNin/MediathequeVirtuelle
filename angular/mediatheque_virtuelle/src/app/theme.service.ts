import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Theme } from './modele/theme';
import { EnumTheme } from './modele/enumTheme';
import { environment } from 'src/environments/environments';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {

  constructor(private http: HttpClient) {

  }

  //subscribe à faire dans le component
  findByLabel(label: string): Observable<Theme[]> {
    return this.http.get<Theme[]>(environment.apiUrl + "/theme/label/" + label);

  }

  //subscribe à faire dans le component
  findByEnumTheme(enumTheme: EnumTheme): Observable<Theme[]> {
    return this.http.get<Theme[]>(environment.apiUrl + "/theme/enumTheme/" + enumTheme);
  }

  //subscribe à faire dans le component
  findByLabelAndEnumTheme(label: string, enumTheme: EnumTheme): Observable<Theme> {
    return this.http.get<Theme>(environment.apiUrl + "/theme/labelAndEnumTheme/" + label + "/" + enumTheme);
  }
}
