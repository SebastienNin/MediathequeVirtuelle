import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Account } from './modele/account';
import { AccountHttpService } from './account-http.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  showErrorConnection: boolean;

  constructor(private accountHttpService: AccountHttpService, private router: Router) { }

  authentication(username: string, password: string) {
    this.accountHttpService.connection(username, password).subscribe(
      {
        next: resp => {
          sessionStorage.setItem("user", JSON.stringify(resp));
          this.router.navigate(["/"]);
          this.showErrorConnection = false;
        },
        error: error => {
          if (error.status == 404) {
            this.showErrorConnection = true;
          }
        }
      })
  }

  disconnection() {
    sessionStorage.removeItem("user");
    this.router.navigate(['/']);
  }

  getUser(): Account {
    let strUser = sessionStorage.getItem("user");

    if (strUser) {
      let user: Account = JSON.parse(strUser);
      return user;
    }
    return null;
  }

  isAuthenticated(): boolean {
    return this.getUser() != null;
  }

  // Ajoutez cette méthode pour mettre à jour l'utilisateur en session
  updateUser(updatedUser: Account): void {
    let strUser = JSON.stringify(updatedUser);
    sessionStorage.setItem("user", strUser);
  }
}
