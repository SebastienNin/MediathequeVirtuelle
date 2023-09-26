import { Component } from '@angular/core';
import { Account } from '../modele/account';
import { AccountService } from './account.service';
import { AccountHttpService } from '../account-http.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent {

  accounts$: Observable<Account[]>;
  users: Array<Account> = new Array<Account>();
  accountForm: Account = null;

  constructor(private accountHttpService: AccountHttpService) {
  }

  ngOnInit(): void {
    this.accounts$ = this.accountHttpService.findAll();
  }

  // add() {
  //   this.accountForm = new Account();
  // }

  edit(id: number) {
    this.accountHttpService.findById(id).subscribe(resp => {
      this.accountForm = resp;
    });
  }

  save() {
    this.accountHttpService.save(this.accountForm).subscribe(resp => {
      this.accounts$ = this.accountHttpService.findAll();
    });
  }

  cancel() {
    this.accountForm = null;
  }

  remove(id: number) {
    this.accountHttpService.deleteById(id).subscribe(resp => {
      this.accounts$ = this.accountHttpService.findAll();
    });
  }
}
