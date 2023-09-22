import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-connection',
  templateUrl: './connection.component.html',
  styleUrls: ['./connection.component.scss']
})
export class ConnectionComponent {

  connectionForm: FormGroup;
  showError: boolean;
  

  constructor(private authService: AuthService, private formBuilder: FormBuilder){
    
  }

  ngOnInit(): void {
    this.connectionForm = this.formBuilder.group({
      username: this.formBuilder.control('', Validators.required),
      password: this.formBuilder.control('', Validators.required)
    })
  }

  connection() {
    this.authService.authentication(this.connectionForm.value.username, this.connectionForm.value.password); 
    this.showError=this.authService.showErrorConnection;
  }

}
