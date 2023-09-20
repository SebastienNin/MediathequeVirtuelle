import { Injectable } from '@angular/core';
import { Account } from '../modele/account';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  accounts: Array<Account> = new Array<Account>();

  constructor() {
    this.accounts.push(new Account(1, 0, "user1", "123456", "utilisateur1", "user", "user@gmail.com", false));
    this.accounts.push(new Account(2, 0, "user2", "123456", "utilisateur2", "user", "user@gmail.com", false));
    this.accounts.push(new Account(3, 0, "admin1", "123456", "administrateur1", "admin", "admin@gmail.com", true));
  }

  findAll(): Array<Account> {
    return this.accounts;
  }

  findById(id: number): Account {
    return this.accounts.find(a => a.id == id);
  }

  save(user: Account): void {
    if (user.id) {
      let pos = this.accounts.findIndex(a => a.id == user.id);
      this.accounts[pos] = user;
    } else {
      let max = 0;
      this.accounts.forEach(a => {
        if (a.id > max) {
          max = a.id;
        }
      });

      user.id = ++max;

      this.accounts.push(user);
    }
  }

  deleteById(id: number) {
    let pos = this.accounts.findIndex(a => a.id == id);

    this.accounts.splice(pos, 1);
  }

  inscription(login: string, password: string, passwordCheck: string, name: string, firstName: string, mail: string) {
    let user: Account = new Account(null, 0, login, password, name, firstName, mail, false);
    this.save(user);
  }

  connection(login: string, password: string): Account {
    return this.accounts.find(a => a.login == login && a.password == password);
  }
}
