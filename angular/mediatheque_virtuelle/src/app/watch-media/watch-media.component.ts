import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Media } from '../modele/media';
import { WatchMediaHttpService } from './watch-media-http.service';
import { Observable } from 'rxjs';
import { WatchMyMediaHttpService } from '../watch-my-media/watch-my-media-http.service';
import { AccountMedia } from '../modele/accountMedia';
import { Account } from '../modele/account';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-watch-media',
  templateUrl: './watch-media.component.html',
  styleUrls: ['./watch-media.component.scss']
})
export class WatchMediaComponent implements OnInit{

  media$: Observable<Media[]>;

  user: Account;
  accountMedia: AccountMedia;

  //boolean pour l'affichage des différents formulaires
  showAllMediaForm : boolean = true;
  showBoardGameForm : boolean = false;
  showBookForm : boolean = false;
  showMagazineForm : boolean = false;
  showMovieForm: boolean = false;
  showMusicForm: boolean = false;
  showVideoGameForm: boolean = false;

  constructor(private authService: AuthService, private watchMyMediaHttpService: WatchMyMediaHttpService, private watchMediaHttpService: WatchMediaHttpService, private router: Router) {
    this.user = this.authService.getUser();
  }
  
  ngOnInit(): void {
    this.media$ = this.watchMediaHttpService.findAll();
  }

  // list(): Array<Media> {
  //   return this.watchMediaHttpSevice.findAll();
  // }

  remove(id: number) {
    this.watchMediaHttpService.deleteById(id);
  }

  //Ajout d'un média, avec redirection vers la page d'ajout d'un média
  addMedia() {
    this.router.navigate(["/media/add"]);
  }

  addToMyMedia(media: Media) {
    this.accountMedia = new AccountMedia(null, this.user, media);

    this.watchMyMediaHttpService.save(this.accountMedia);
  }

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
