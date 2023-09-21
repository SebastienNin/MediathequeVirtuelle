import { Component, OnInit } from '@angular/core';
import { PersonnalizedList } from '../modele/personnalizedList';
import { PersoListService } from './perso-list.service';
import { Account } from '../modele/account';

@Component({
  selector: 'app-perso-list',
  templateUrl: './perso-list.component.html',
  styleUrls: ['./perso-list.component.scss']
})
export class PersoListComponent implements OnInit {

  persoLists: Array<PersonnalizedList> = [];
  personnalizedListForm: PersonnalizedList = null;

  constructor(private persoListService: PersoListService) {}

  ngOnInit(): void {
    this.persoLists = this.persoListService.findAll();
  }

  createPersonnalizedList(account: Account) {
    const newPersonnalizedList = new PersonnalizedList();
    this.persoListService.createWithAccount(newPersonnalizedList, account);
    this.persoLists = this.persoListService.findAll(); // Mise à jour de la liste après la création
  }

  edit(id: number) {
    // Récupération de la PersonnalizedList à éditer par son ID
    const personnalizedListToEdit = this.persoListService.findById(id);

    if (personnalizedListToEdit) {
      // Attribution de la PersonnalizedList à personnalizedListForm pour l'édition
      this.personnalizedListForm = personnalizedListToEdit;
    } else {
      // Afficher un message d'erreur ou gérer le cas où la PersonnalizedList n'est pas trouvée
    }
  }

  updatePersonnalizedList(personnalizedList: PersonnalizedList, account: Account) {
    this.persoListService.createWithAccount(personnalizedList, account);
    this.persoLists = this.persoListService.findAll(); // Mise à jour de la liste après la mise à jour
  }

  deletePersonnalizedList(id: number) {
    this.persoListService.deleteById(id);
    this.persoLists = this.persoListService.findAll(); // Mise à jour de la liste après la suppression
  }
  save() {
    if (this.personnalizedListForm.id) {
      // Mise à jour de la PersonnalizedList existante
      this.updatePersonnalizedList(this.personnalizedListForm, this.personnalizedListForm.account);
    } else {
      // Création d'une nouvelle PersonnalizedList
      const account = new Account(); // Vous devez définir les détails du compte ici
      this.createPersonnalizedList(account);
    }

    // Réinitialisation du formulaire
    this.cancel();
  }

  cancel() {
    // Réinitialisation du formulaire en définissant personnalizedListForm sur null
    this.personnalizedListForm = null;
  }
}


