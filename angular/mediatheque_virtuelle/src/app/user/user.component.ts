import { Component } from '@angular/core';
import { Account } from '../modele/account';
import { UserService } from './user.service';

@Component({
  selector: 'user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent {

  users: Array<Account> = new Array<Account>();
  userForm: Account = null;

  constructor(private userService: UserService) {
    this.users = userService.findAll()
  }

  add() {
    this.userForm = new Account();
  }

  edit(id: number) {
    this.userForm = this.userService.findById(id);
  }

  save() {
    this.userService.save(this.userForm);
  }

  cancel() {
    this.userForm = null;
  }

  remove(id: number) {
    this.userService.deleteById(id);
  }

}
