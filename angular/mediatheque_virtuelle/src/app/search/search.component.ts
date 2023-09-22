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
  selectedMediaType: string;

  constructor(private searchHttpService: SearchHttpService) { }

  // search() {
  //   this.searchService.search(this.query).subscribe((data) => {
  //     this.results = data;
  //   });
  // }

  searchByTitleAndType() {
    const query = this.query;
    const mediaType = this.selectedMediaType || ''; // Utilisez une chaîne vide si aucun type n'est sélectionné
    this.searchHttpService.searchByTitleAndType(query, mediaType).subscribe((data) => {
      this.results = data;
    });
  }

}
