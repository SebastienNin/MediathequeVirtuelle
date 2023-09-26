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
  idAccountForm: number;
  editForm: PersonnalizedList = null;
  addForm: PersonnalizedList = null;

  constructor(private personnalizedListHttpService: PersonnalizedListHttpService, private accountHttpService: AccountHttpService) { }

  ngOnInit(): void {
    this.personnalizedLists$ = this.personnalizedListHttpService.findAll();
    this.accounts$ = this.accountHttpService.findAll();
    this.personnalizedListHttpService.findAll().subscribe(resp => console.log(resp));

  }
  add() {
    this.editForm = null;
    this.addForm = new PersonnalizedList();
    this.addForm.account = new Account();
  }

  edit(id: number) {
    this.addForm = null;
    this.personnalizedListHttpService.findById(id).subscribe(resp => {
      this.editForm = resp;

      if (!this.editForm.account) {
        this.editForm.account = new Account();
      }
    });
  }

  saveEdit() {
    console.log(this.editForm)
    this.personnalizedListHttpService.save(this.editForm).subscribe(() => {
      this.personnalizedLists$ = this.personnalizedListHttpService.findAll();
      this.cancel();
    });
  }

  saveAdd() {
    this.accountHttpService.findById(this.idAccountForm).subscribe(resp => {
      this.addForm.account = resp;
    
      this.personnalizedListHttpService.save(this.addForm).subscribe(() => {
        this.personnalizedLists$ = this.personnalizedListHttpService.findAll();
        this.cancel();
      });
    });
  }

  cancel() {
    this.editForm = null;
    this.addForm = null;
    this.idAccountForm = null;
  }


  delete(id: number) {
    this.personnalizedListHttpService.deleteById(id).subscribe(() => {
      this.personnalizedLists$ = this.personnalizedListHttpService.findAll();
    });
  }
}
