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
  utilisateurForm: Account = null;

  constructor(private userService: UserService) {
    this.users = userService.findAll()
  }


}
