import { Component, OnInit } from '@angular/core';
import { WatchMediaHttpService } from '../watch-media/watch-media-http.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Media } from '../modele/media';
import { WatchMyMediaHttpService } from './watch-my-media-http.service';
import { AuthService } from '../auth.service';
import { Account } from '../modele/account';
import { AccountMedia } from '../modele/accountMedia';

@Component({
  selector: 'app-watch-my-media',
  templateUrl: './watch-my-media.component.html',
  styleUrls: ['./watch-my-media.component.scss']
})
export class WatchMyMediaComponent implements OnInit{

  accountMedia$: Observable<AccountMedia[]>;

  user: Account;

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
    this.accountMedia$ = this.watchMyMediaHttpService.findAllForAsyn()
  }

  list(): Array<AccountMedia> {
    return this.watchMyMediaHttpService.findAll();
  }

  remove(id: number) {
    this.watchMediaHttpService.deleteById(id);
  }

  findAccount() {
    console.log(this.user.id);
    // this.watchMyMediaHttpService.findByAccount(this.user.id);
  }
  deleteToMyMedia(id: number) {
    this.watchMyMediaHttpService.deleteById(id);
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
