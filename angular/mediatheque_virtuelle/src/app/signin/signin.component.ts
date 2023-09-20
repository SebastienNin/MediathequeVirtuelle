import { Component } from '@angular/core';
import { AccountService } from '../account/account.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent {
  login: string;
  password: string;
  passwordVerif: string;
  name: string;
  firstName: string;
  mail: string;

  constructor(private accountService: AccountService, private router: Router) {

  }

  valider() {
    this.accountService.inscription(this.login, this.password, this.passwordVerif, this.name, this.firstName, this.mail);
  }
}
