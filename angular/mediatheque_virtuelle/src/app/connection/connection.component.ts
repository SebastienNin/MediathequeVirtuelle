import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-connection',
  templateUrl: './connection.component.html',
  styleUrls: ['./connection.component.scss']
})
export class ConnectionComponent {

  connectionForm: FormGroup;

  constructor(private authService: AuthService, private formBuilder: FormBuilder){

  }

  ngOnInit(): void {
    this.connectionForm = this.formBuilder.group({
      username: this.formBuilder.control(''),
      password: this.formBuilder.control('')
    })
  }

  connection() {
    this.authService.authentication(this.connectionForm.value.username, this.connectionForm.value.password); 
  }

}
