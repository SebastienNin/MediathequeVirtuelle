import { Injectable } from '@angular/core';
import { PersonnalizedList } from '../modele/personnalizedList';
import { Account } from '../modele/account';


@Injectable({
  providedIn: 'root'
})
export class PersonnalizedListService {

  personnalizedLists : Array<PersonnalizedList> = new Array<PersonnalizedList>()

  constructor() {
    this.personnalizedLists.push(new PersonnalizedList(1,"sdjhfndskjgh",null))
    this.personnalizedLists.push(new PersonnalizedList(2,"sdjhdfgdfndskjgh",null))
    this.personnalizedLists.push(new PersonnalizedList(3,"sdbcvjhfndskjgh",null))
   }

  findAll(): Array<PersonnalizedList> {
    return this.personnalizedLists;
  }

  findById(id: number): PersonnalizedList {
    return this.personnalizedLists.find(a => a.id == id);
  }

  save(user: PersonnalizedList): void {
    if (user.id) {
      let pos = this.personnalizedLists.findIndex(a => a.id == user.id);
      this.personnalizedLists[pos] = user;
    } else {
      let max = 0;
      this.personnalizedLists.forEach(a => {
        if (a.id > max) {
          max = a.id;
        }
      });

      user.id = ++max;

      this.personnalizedLists.push(user);
    }
  }

  deleteById(id: number) {
    let pos = this.personnalizedLists.findIndex(a => a.id == id);

    this.personnalizedLists.splice(pos, 1);
  }
  createWithAccount(personnalizedList: PersonnalizedList, account: Account): void {
    personnalizedList.account = account;
    this.save(personnalizedList);
  }

  



}
