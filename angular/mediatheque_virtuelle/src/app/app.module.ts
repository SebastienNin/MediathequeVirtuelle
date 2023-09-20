import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

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
import { AccountHttpService } from './account/account-http.service';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    SigninComponent,
    AccountComponent,
    ConnectionComponent,
    AccueilComponent,
    MatchPasswordDirective,
    AccountComponent,
    AddMediaComponent,
    PersoListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [AccountHttpService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
