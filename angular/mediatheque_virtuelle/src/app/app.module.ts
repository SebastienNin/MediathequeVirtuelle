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
import { AccountHttpService } from './account-http.service';
import { MyAccountComponent } from './my-account/my-account.component';
import { PersonnalizedListComponent } from './personnalizedList/personnalizedList.component';
import { SeeMediaDetailsComponent } from './see-media-details/see-media-details.component';
import { WatchMediaComponent } from './watch-media/watch-media.component';
import { SearchComponent } from './search/search.component';
import { MyPersoListComponent } from './my-perso-list/my-perso-list.component';
import { WatchMyMediaComponent } from './watch-my-media/watch-my-media.component';
import { PersoListJoinMediaComponent } from './perso-list-join-media/perso-list-join-media.component';
import { PersoListJoinMediaHttpService } from './perso-list-join-media/perso-list-join-media-http.service';

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
    MyAccountComponent,
    PersonnalizedListComponent,
    SeeMediaDetailsComponent,
    WatchMediaComponent,
    SearchComponent,
    MyPersoListComponent,
    WatchMyMediaComponent,
    PersoListJoinMediaComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [AccountHttpService, PersoListJoinMediaHttpService], 
  bootstrap: [AppComponent]
})
export class AppModule { }
