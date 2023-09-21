import { Injectable } from '@angular/core';
import { AccountService } from './account/account.service';
import { Router } from '@angular/router';
import { Account } from './modele/account';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private accountService: AccountService, private router: Router) { }

  authentication(username: string, password: string) {
    let user = this.accountService.connection(username, password);

    if(user){
      sessionStorage.setItem("user", JSON.stringify(user));
      this.router.navigate([ '/' ]);
    }
    else{
      alert("Ton identifiant ou mot de passe est incorrect");
    }
  }

  disconnection() {
    sessionStorage.removeItem("user");
    this.router.navigate([ '/' ]);
  }

  getUser(): Account {
    let strUser = sessionStorage.getItem("user");

    if(strUser) {
      let user: Account = JSON.parse(strUser);
      return user;
    }
    return null;
  }

  isAuthenticated(): boolean {
    return this.getUser() != null;
  }
}
