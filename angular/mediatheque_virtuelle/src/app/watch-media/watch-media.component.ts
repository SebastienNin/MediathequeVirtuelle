import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Media } from '../modele/media';
import { WatchMediaHttpService } from './watch-media-http.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-watch-media',
  templateUrl: './watch-media.component.html',
  styleUrls: ['./watch-media.component.scss']
})
export class WatchMediaComponent implements OnInit{

  media$: Observable<Media[]>;

  //boolean pour l'affichage des différents formulaires
  // showAllMediaForm : boolean = true;
  // showBoardGameForm : boolean = false;
  // showBookForm : boolean = false;
  // showMagazineForm : boolean = false;
  // showMovieForm: boolean = false;
  // showMusicForm: boolean = false;
  // showVideoGameForm: boolean = false;

  constructor(private watchMediaHttpSevice: WatchMediaHttpService, private router: Router) {}
  
  ngOnInit(): void {
    this.media$ = this.watchMediaHttpSevice.findAll();
  }

  // list(): Array<Media> {
  //   return this.watchMediaHttpSevice.findAll();
  // }

//   remove(id: number) {
//     this.watchMediaHttpSevice.deleteById(id);
//   }

//   //Ajout d'un média, avec redirection vers la page d'ajout d'un média
//   addMedia() {
//     this.router.navigate(["/media/add"]);
//   }

//   addToMyMedia() {}

//   //Afficher les listes des Médias correspondant
//   showAllMedia() {
//     this.showAllMediaForm = true;
//     this.showBoardGameForm = false;
//     this.showBookForm = false;
//     this.showMagazineForm = false;
//     this.showMovieForm = false;
//     this.showMusicForm = false;
//     this.showVideoGameForm = false;
//   }

//   showBoardGameList() {
//     this.showAllMediaForm = false;
//     this.showBoardGameForm = true;
//     this.showBookForm = false;
//     this.showMagazineForm = false;
//     this.showMovieForm = false;
//     this.showMusicForm = false;
//     this.showVideoGameForm = false;
//   }

//   showBookList() {
//     this.showAllMediaForm = false;
//     this.showBoardGameForm = false;
//     this.showBookForm = true;
//     this.showMagazineForm = false;
//     this.showMovieForm = false;
//     this.showMusicForm = false;
//     this.showVideoGameForm = false;
//   }

//   showMagazineList() {
//     this.showAllMediaForm = false;
//     this.showBoardGameForm = false;
//     this.showBookForm = false;
//     this.showMagazineForm = true;
//     this.showMovieForm = false;
//     this.showMusicForm = false;
//     this.showVideoGameForm = false;
//   }

//   showMovieList() {
//     this.showAllMediaForm = false;
//     this.showBoardGameForm = false;
//     this.showBookForm = false;
//     this.showMagazineForm = false;
//     this.showMovieForm = true;
//     this.showMusicForm = false;
//     this.showVideoGameForm = false;
//   }

//   showMusicList() {
//     this.showAllMediaForm = false;
//     this.showBoardGameForm = false;
//     this.showBookForm = false;
//     this.showMagazineForm = false;
//     this.showMovieForm = false;
//     this.showMusicForm = true;
//     this.showVideoGameForm = false;
//   }

//   showVideoGameList() {
//     this.showAllMediaForm = false;
//     this.showBoardGameForm = false;
//     this.showBookForm = false;
//     this.showMagazineForm = false;
//     this.showMovieForm = false;
//     this.showMusicForm = false;
//     this.showVideoGameForm = true;
//   }

 }
