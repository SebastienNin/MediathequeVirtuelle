import { Injectable } from '@angular/core';
import { Account } from '../modele/account';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users: Array<Account> = new Array<Account>();

  constructor() { 
    this.users.push(new Account(1, 0, "user1", "123456", "utilisateur1", "user", "user@gmail.com", false));
    this.users.push(new Account(2, 0, "user2", "123456", "utilisateur2", "user", "user@gmail.com", false));
    this.users.push(new Account(3, 0, "admin1", "123456", "administrateur1", "admin", "admin@gmail.com", true));
  }

  findAll() : Array<Account> {
    return this.users;
   }

   findById(id: number): Account {
    return this.users.find(u => u.id == id);
   }

   save(utilisateur: Account): void {
    if(utilisateur.id) {
      let pos = this.users.findIndex(u => u.id == utilisateur.id);
      this.users[pos] = utilisateur;
    } else {
      let max = 0;
      this.users.forEach(u => {
        if(u.id > max) {
          max = u.id;
        }
      });

      utilisateur.id = ++max;

      this.users.push(utilisateur);
    }
   }

   deleteById(id: number) {
    let pos = this.users.findIndex(u => u.id == id);

    this.users.splice(pos, 1);
   }

   inscription(login: string, password: string, name: string, firstName: string, mail: string) {
    let utilisateur: Account = new Account(null, 0, login, password, name, firstName, mail, false);

    this.save(utilisateur);
   }

   connexion(login: string, password: string):Account {
    return this.users.find(u => u.login == login && u.password == password);
   }
}
