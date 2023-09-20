import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-connection',
  templateUrl: './connection.component.html',
  styleUrls: ['./connection.component.scss']
})
export class ConnectionComponent {

  connectionForm: FormGroup;

  constructor(private formBuilder: FormBuilder){

  }

  ngOnInit(): void {
    this.connectionForm = this.formBuilder.group({
      identifiant: this.formBuilder.control(''),
      password: this.formBuilder.control('')
    })
  }

  connection() {
    
  }

}
