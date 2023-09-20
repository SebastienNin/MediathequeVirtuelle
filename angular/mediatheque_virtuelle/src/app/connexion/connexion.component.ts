import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent {

  connexionForm: FormGroup;

  constructor(private formBuilder: FormBuilder){

  }

  ngOnInit(): void {
    this.connexionForm = this.formBuilder.group({
      identifiant: this.formBuilder.control(''),
      password: this.formBuilder.control('')
    })
  }

  connexion() {

  }
}
