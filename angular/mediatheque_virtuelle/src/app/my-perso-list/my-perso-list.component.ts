import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { PersonnalizedList } from '../modele/personnalizedList';
import { Account } from '../modele/account';
import { PersonnalizedListHttpService } from '../personnalizedList-http.service';
import { AccountHttpService } from '../account-http.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-perso-list',
  templateUrl: './my-perso-list.component.html',
  styleUrls: ['./my-perso-list.component.scss']
})
export class MyPersoListComponent implements OnInit {

  account: Account;
  myPersoLists$: Observable<PersonnalizedList[]>;
  persoListForm: PersonnalizedList;

  constructor(private router: Router, private persoListService: PersonnalizedListHttpService, private authService: AuthService) {

  }
  ngOnInit(): void {
    this.account = this.authService.getUser();
    this.myPersoLists$ = this.persoListService.findByAccount(this.account);
  }

  redirectToMediaList(id: number): void {
    this.router.navigate([`/persoListJoinMedia/${id}`]);
  }

  add() {
    this.persoListForm = new PersonnalizedList();
    this.persoListForm.account = this.account;
  }

  edit(id: number) {
    this.persoListService.findById(id).subscribe(resp => this.persoListForm = resp);

  }

  save() {
    this.persoListService.save(this.persoListForm).subscribe(resp => {
      this.myPersoLists$ = this.persoListService.findByAccount(this.account);
      this.persoListForm = null;
    })
  }

  cancel() {
    this.persoListForm = null;
  }

  delete(id: number) {
    this.persoListService.deleteById(id).subscribe(resp => {
      this.myPersoLists$ = this.persoListService.findByAccount(this.account);
    })
  }



}
