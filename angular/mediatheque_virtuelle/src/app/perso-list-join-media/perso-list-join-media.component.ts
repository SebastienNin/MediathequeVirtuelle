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

  constructor(
    private route: ActivatedRoute,
    private persoListJoinMediaHttpService: PersoListJoinMediaHttpService
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.persoListId = +params['id']; // Obtenez l'ID depuis la route
      // Utilisez this.persoListId pour récupérer les médias associés depuis votre service HTTP
      this.persoListJoinMedia$ = this.persoListJoinMediaHttpService.findByPersoList(this.persoListId);
      console.log(this.persoListJoinMedia$);
    });
  }
}
