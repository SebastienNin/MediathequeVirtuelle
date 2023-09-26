import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AccountHttpService } from '../account-http.service';
import { AbstractControl, FormBuilder, FormGroup, ValidatorFn, Validators } from '@angular/forms';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent {

  signinForm: FormGroup;

  constructor(private accountHttpService: AccountHttpService, private router: Router, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.signinForm = this.formBuilder.group({
      login: this.formBuilder.control("", Validators.required),
      password: this.formBuilder.control("", Validators.required),
      passwordCheck: this.formBuilder.control("", Validators.required),
      name: this.formBuilder.control("", Validators.required),
      firstName: this.formBuilder.control("", Validators.required),
      mail: this.formBuilder.control("", [Validators.required, Validators.email]),
    });
  }

  validateForm() {
    this.accountHttpService.signin(
      this.signinForm.value.login,
      this.signinForm.value.password,
      this.signinForm.value.passwordCheck,
      this.signinForm.value.name,
      this.signinForm.value.firstName,
      this.signinForm.value.mail
    ).subscribe(
      resp => {
        // alert("Compte créé, vous allez être redirigée vers la page de connexion.");
        this.router.navigate(["/connection"]);
      }
    );
  }
}
