import { Component } from '@angular/core';

@Component({
  selector: 'app-watch-media',
  templateUrl: './watch-media.component.html',
  styleUrls: ['./watch-media.component.scss']
})
export class WatchMediaComponent {

  //boolean pour l'affichage des différents formulaires
  showAllMediaForm : boolean = true;
  showBoardGameForm : boolean = false;
  showBookForm : boolean = false;
  showMagazineForm : boolean = false;
  showMovieForm: boolean = false;
  showMusicForm: boolean = false;
  showVideoGameForm: boolean = false;

  //Afficher les listes des Médias correspondant
  showAllMedia() {
    this.showAllMediaForm = true;
    this.showBoardGameForm = false;
    this.showBookForm = false;
    this.showMagazineForm = false;
    this.showMovieForm = false;
    this.showMusicForm = false;
    this.showVideoGameForm = false;
  }

  showBoardGameList() {
    this.showAllMediaForm = false;
    this.showBoardGameForm = true;
    this.showBookForm = false;
    this.showMagazineForm = false;
    this.showMovieForm = false;
    this.showMusicForm = false;
    this.showVideoGameForm = false;
  }

  showBookList() {
    this.showAllMediaForm = false;
    this.showBoardGameForm = false;
    this.showBookForm = true;
    this.showMagazineForm = false;
    this.showMovieForm = false;
    this.showMusicForm = false;
    this.showVideoGameForm = false;
  }

  showMagazineList() {
    this.showAllMediaForm = false;
    this.showBoardGameForm = false;
    this.showBookForm = false;
    this.showMagazineForm = true;
    this.showMovieForm = false;
    this.showMusicForm = false;
    this.showVideoGameForm = false;
  }

  showMovieList() {
    this.showAllMediaForm = false;
    this.showBoardGameForm = false;
    this.showBookForm = false;
    this.showMagazineForm = false;
    this.showMovieForm = true;
    this.showMusicForm = false;
    this.showVideoGameForm = false;
  }

  showMusicList() {
    this.showAllMediaForm = false;
    this.showBoardGameForm = false;
    this.showBookForm = false;
    this.showMagazineForm = false;
    this.showMovieForm = false;
    this.showMusicForm = true;
    this.showVideoGameForm = false;
  }

  showVideoGameList() {
    this.showAllMediaForm = false;
    this.showBoardGameForm = false;
    this.showBookForm = false;
    this.showMagazineForm = false;
    this.showMovieForm = false;
    this.showMusicForm = false;
    this.showVideoGameForm = true;
  }

}
