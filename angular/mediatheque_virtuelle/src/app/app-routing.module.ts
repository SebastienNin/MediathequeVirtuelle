import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SigninComponent } from './signin/signin.component';
import { AddMediaComponent } from './add-media/add-media.component';
import { ConnectionComponent } from './connection/connection.component';
import { authGuard } from './auth.guard';
import { AccountComponent } from './account/account.component';
import { AccueilComponent } from './accueil/accueil/accueil.component';

const routes: Routes = [
  {path: "", component: AccueilComponent, pathMatch: 'full'},
  {path: "account", component: AccountComponent, canActivate: [authGuard]},
  {path: "connection", component: ConnectionComponent},
  {path: "signin", component: SigninComponent},
  {path: "media/add", component: AddMediaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
