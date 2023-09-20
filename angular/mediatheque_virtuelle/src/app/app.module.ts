import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SigninComponent } from './signin/signin.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConnectionComponent } from './connection/connection.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { AccueilComponent } from './accueil/accueil.component';
import { MatchPasswordDirective } from './match-password.directive';
import { AccountComponent } from './account/account.component';
import { AddMediaComponent } from './add-media/add-media.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    SigninComponent,
<<<<<<< Updated upstream
=======
    AccountComponent,
>>>>>>> Stashed changes
    ConnectionComponent,
    AccueilComponent,
    MatchPasswordDirective,
    AccountComponent,
    AddMediaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
