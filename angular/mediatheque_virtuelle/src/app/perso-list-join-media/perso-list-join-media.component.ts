import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Media } from '../modele/media';
import { PersoListJoinMedia } from '../modele/persoListJoinMedia';
import { PersoListJoinMediaHttpService } from './perso-list-join-media-http.service';
import { WatchMediaHttpService } from '../watch-media/watch-media-http.service';
import { Account } from '../modele/account';
import { AuthService } from '../auth.service';
import { PersonnalizedList } from '../modele/personnalizedList';
import { PersonnalizedListHttpService } from '../personnalizedList-http.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';



@Component({
  selector: 'app-perso-list-join-media',
  templateUrl: './perso-list-join-media.component.html',
  styleUrls: ['./perso-list-join-media.component.scss']
})
export class PersoListJoinMediaComponent implements OnInit {
  persoListId: number;
  persoListJoinMedia$: Observable<PersoListJoinMedia[]>;


  showAllMediaForm : boolean = true;
  showBoardGameForm : boolean = false;
  showBookForm : boolean = false;
  showMagazineForm : boolean = false;
  showMovieForm: boolean = false;
  showMusicForm: boolean = false;
  showVideoGameForm: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private persoListJoinMediaHttpService: PersoListJoinMediaHttpService
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.persoListId = +params['id'];
      this.persoListJoinMedia$ = this.persoListJoinMediaHttpService.findByPersoList(this.persoListId);
    });
  }

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

