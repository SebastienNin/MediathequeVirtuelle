import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AccountHttpService } from '../account/account-http.service';

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

  constructor(private accountHttpService: AccountHttpService, private router: Router) {

  }

  valider() {
    this.accountHttpService.signin(this.login, this.password, this.passwordVerif, this.name, this.firstName, this.mail).subscribe(resp => {
      this.router.navigate(["/connection"]);
    });
  }
}
