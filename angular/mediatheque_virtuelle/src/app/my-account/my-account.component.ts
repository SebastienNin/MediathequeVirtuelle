import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Account } from '../modele/account';
import { AbstractControl, FormBuilder, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { AccountHttpService } from '../account/account-http.service';

@Component({
  selector: 'app-my-account',
  templateUrl: './my-account.component.html',
  styleUrls: ['./my-account.component.scss']
})
export class MyAccountComponent {
  user: Account;
  selectedMenu: string;

  editInfoFormGroup: FormGroup;
  changePasswordFormGroup: FormGroup;

  constructor(private authService: AuthService, private formBuilder: FormBuilder, private accountHttpService: AccountHttpService) {
    this.user = this.authService.getUser();
    this.selectedMenu = 'info'; // Par défaut, affichez les informations de l'utilisateur

    this.editInfoFormGroup = this.formBuilder.group({
      login: [this.user.login, Validators.required], // Exemple de validation avec Validators.required
      name: [this.user.name, Validators.required],
      firstName: [this.user.firstName, Validators.required],
      mail: [this.user.mail, [Validators.required, Validators.email]]
    });

    this.changePasswordFormGroup = this.formBuilder.group({
      currentPassword: ['', [Validators.required, this.validateCurrentPassword.bind(this)]],
      newPassword: ['', Validators.required],
      confirmNewPassword: ['', [Validators.required]]
    });
  }

  selectMenu(menu: string) {
    this.selectedMenu = menu;
  }

  updateUserInfo() {
    const updatedUserInfo = this.editInfoFormGroup.value;
    let user = { ...this.user, ...updatedUserInfo };
    this.accountHttpService.save(user).subscribe(
      (resp) => {
        alert("Informations mises à jour avec succès.");
        this.user = resp;
      }
    );
  }

  validateCurrentPassword(control: AbstractControl): ValidationErrors | null {
    const currentPasswordFromForm = control.value;
    if (currentPasswordFromForm) {
      if (currentPasswordFromForm !== this.user.password)
        return { invalidFormPassword: 'Le mot de passe ne correspond pas à votre mot de passe enregistré' };
    }
    return null; // Valide si tout est en ordre
  }

  updatePassword() {
    this.user.password = this.changePasswordFormGroup.value.newPassword;
    this.accountHttpService.save(this.user).subscribe(resp => {
      alert("Mot de passe mis à jour avec succès.");
      this.changePasswordFormGroup.reset();
      this.user = resp;
    });
  }
}
