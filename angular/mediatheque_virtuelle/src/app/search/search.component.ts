import { Component } from '@angular/core';
import { SearchHttpService } from './search-http.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent {
  query: string;
  results: any[]; // Vous devrez définir la structure des résultats en fonction de votre backend
  selectedMediaType: string = "";

  constructor(private searchHttpService: SearchHttpService) { }

  // Method launched by the "Rechercher" button from the HTML page
  search() {
    if (!this.query && this.selectedMediaType == "") {
      this.searchHttpService.listAll().subscribe((data) => {
        this.results = data;
      });
    // } else if(!this.query && this.selectedMediaType!= ""){
    //   this.searchHttpService.search(this.selectedMediaType).subscribe((data) => {
    //     this.results = data;
    //   });
    } else if(this.query && this.selectedMediaType == ""){
      this.searchHttpService.searchByTitle(this.query).subscribe((data) => {
        this.results = data;
      });
    }
  }

  // searchByTitleAndType() {
  //   const query = this.query;
  //   const mediaType = this.selectedMediaType || ''; // Utilisez une chaîne vide si aucun type n'est sélectionné
  //   this.searchHttpService.searchByTitleAndType(query, mediaType).subscribe((data) => {
  //     this.results = data;
  //   });
  // }

}
