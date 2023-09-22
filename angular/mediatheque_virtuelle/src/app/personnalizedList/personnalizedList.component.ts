import { Component, OnInit } from '@angular/core';
import { PersonnalizedList } from '../modele/personnalizedList';
import { PersonnalizedListHttpService } from './personnalizedList-http.service';
import { Observable } from 'rxjs';
import { Account } from '../modele/account';
import { AccountHttpService } from '../account/account-http.service';

@Component({
  selector: 'app-perso-list',
  templateUrl: './personnalizedList.component.html',
  styleUrls: ['./personnalizedList.component.scss']
})

export class PersonnalizedListComponent implements OnInit {

  personnalizedLists$: Observable<PersonnalizedList[]>;
  accounts$: Observable<Account[]>;
  personnalizedListForm: PersonnalizedList = null;
  personnalizedListFormVide: PersonnalizedList = null;
  showEditForm: boolean = false;

  constructor(private personnalizedListHttpService: PersonnalizedListHttpService, private accountHttpService: AccountHttpService) {}

  ngOnInit(): void {
    this.personnalizedLists$ = this.personnalizedListHttpService.findAll();
    this.accounts$ = this.accountHttpService.findAll();
  }
  add() {
    this.personnalizedListFormVide = new PersonnalizedList();
    this.showEditForm = true;
  }

  edit(id: number) {
    this.personnalizedListHttpService.findById(id).subscribe(resp => {
      this.personnalizedListForm = resp;
      this.showEditForm = true;
    });
  }

  save() {
    this.personnalizedListHttpService.save(this.personnalizedListForm).subscribe(() => {
      this.personnalizedLists$ = this.personnalizedListHttpService.findAll();
      this.cancel();
    });
  }

  save2() {
    this.personnalizedListHttpService.save(this.personnalizedListFormVide).subscribe(() => {
      this.personnalizedLists$ = this.personnalizedListHttpService.findAll();
      this.cancel();
    });
  }

  cancel() {
    this.personnalizedListForm = null;
    this.showEditForm = false;
  }

  erase(){
    this.personnalizedListForm = null;
  }

  delete(id: number) {
    this.personnalizedListHttpService.deleteById(id).subscribe(() => {
      this.personnalizedLists$ = this.personnalizedListHttpService.findAll();
    });
  }
}
