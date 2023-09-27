import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Media } from '../modele/media';
import { PersoListJoinMedia } from '../modele/persoListJoinMedia';
import { PersoListJoinMediaHttpService } from './perso-list-join-media-http.service';
import { WatchMediaHttpService } from '../watch-media/watch-media-http.service';

@Component({
  selector: 'app-perso-list-join-media',
  templateUrl: './perso-list-join-media.component.html',
  styleUrls: ['./perso-list-join-media.component.scss']
})
export class PersoListJoinMediaComponent implements OnInit{

  persoListJoinMedia$: Observable<PersoListJoinMedia[]>;

  constructor(private persoListJoinMediaHttpService: PersoListJoinMediaHttpService){}

  ngOnInit(): void {
    this.persoListJoinMediaHttpService.findAll().subscribe(
      (data) => {
        this.persoListJoinMedia$ = this.persoListJoinMediaHttpService.findAll()
      },
      (error) => {
        console.error("Erreur lors de la récupération des données:", error);
      }
    );;
  }
}
