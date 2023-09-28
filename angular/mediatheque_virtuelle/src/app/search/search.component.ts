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
  mediaThemeListFromBack: any[] = [];
  mediaThemeList: string[] = [];
  selectedMediaTheme: string = "";
  searchedByMediaType: boolean = false;

  constructor(private searchHttpService: SearchHttpService) { }

  // Method launched by the "Rechercher" button from the HTML page
  search() {
    if (!this.query && !this.selectedMediaType) {
      this.searchHttpService.listAll().subscribe((data) => {
        this.results = data;
        this.searchedByMediaType = false;
      });
    } else if (!this.query && this.selectedMediaType && !this.selectedMediaTheme) {
      this.searchHttpService.searchByMediaType(this.selectedMediaType).subscribe((data) => {
        this.results = data;
        this.searchedByMediaType = true;
      });
    // } else if (!this.query && this.searchedByMediaType && this.selectedMediaTheme) {
    //   console.log(this.selectedMediaTheme);
    //   this.searchHttpService.searchByTheme(this.selectedMediaTheme).subscribe((data) => {
    //     this.results = data;
    //     console.log(data);
    //   });
    } else if (this.query && this.selectedMediaType != "") {
      this.searchHttpService.searchByMediaTypeAndTitleContaining(this.selectedMediaType, this.query).subscribe((data) => {
        this.results = data;
        this.searchedByMediaType = true;
      });
    } else if (this.query && this.selectedMediaType == "") {
      this.searchHttpService.searchByTitle(this.query).subscribe((data) => {
        this.results = data;
        this.searchedByMediaType = false;
      });
    }
  }

  getThemesByMediaType(selectedMediaType: string): void {
    if (selectedMediaType) {
      if(selectedMediaType == "BOARD_GAME"){
        selectedMediaType = "BOARDGAME";
      }else if(selectedMediaType == "VIDEO_GAME"){
        selectedMediaType = "VIDEOGAME";
      }
      this.searchHttpService.findAllTheme(selectedMediaType)
        .subscribe(themes => {
          this.mediaThemeListFromBack = themes;
        });
    }
  }
  
}
