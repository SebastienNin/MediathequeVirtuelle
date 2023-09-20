import { Component } from '@angular/core';
import { Account } from '../modele/account';
import { AccountService } from './account.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent {
  users: Array<Account> = new Array<Account>();
  userForm: Account = null;

  constructor(private accountService: AccountService) {
    this.users = accountService.findAll()
  }

  add() {
    this.userForm = new Account();
  }

  edit(id: number) {
    this.userForm = this.accountService.findById(id);
  }

  save() {
    this.accountService.save(this.userForm);
  }

  cancel() {
    this.userForm = null;
  }

  remove(id: number) {
    this.accountService.deleteById(id);
  }

}
