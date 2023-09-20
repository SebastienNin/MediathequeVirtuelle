import { Component } from '@angular/core';
import { UserService } from '../user/user.service';
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

  constructor(private userService: UserService, private router: Router) {

  }

  valider() {
    this.userService.inscription(this.login, this.password, this.passwordVerif, this.name, this.firstName, this.mail);
  }
}
