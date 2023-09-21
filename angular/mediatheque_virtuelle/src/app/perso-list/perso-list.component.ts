import { Component, OnInit } from '@angular/core';
import { PersonnalizedList } from '../modele/personnalizedList';
import { PersoListHttpService } from './perso-list-http.service';
import { Account } from '../modele/account';
import { Observable } from 'rxjs';
import { AccountHttpService } from '../account/account-http.service';

@Component({
  selector: 'app-perso-list',
  templateUrl: './perso-list.component.html',
  styleUrls: ['./perso-list.component.scss']
})

export class PersoListComponent implements OnInit {

  personnalizedLists$: Observable<PersonnalizedList[]>;
  
  accounts$: Observable<Account[]>;  
  
  personnalizedListForm: PersonnalizedList = null;


  constructor(private persoListHttpService: PersoListHttpService, private accountHttpService: AccountHttpService) {}


  ngOnInit(): void {
    this.personnalizedLists$ = this.persoListHttpService.findAll();
    this.accounts$ = this.accountHttpService.findAll();
  }


  edit(id: number) {
    this.persoListHttpService.findById(id).subscribe(resp => {
      this.personnalizedListForm = resp;
    });
  }

  save() {
    this.persoListHttpService.save(this.personnalizedListForm).subscribe(resp => {
      this.personnalizedLists$ = this.persoListHttpService.findAll();
    });
  }

  cancel() {
    this.personnalizedListForm = null;
  }

  remove(id: number) {
    this.persoListHttpService.deleteById(id).subscribe(resp => {
      this.personnalizedLists$ = this.persoListHttpService.findAll();
    });
  }
}


