import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { SigninComponent } from './signin/signin.component';
import { ConnectionComponent } from './connection/connection.component';
import { AccueilComponent } from './accueil/accueil/accueil.component';

const routes: Routes = [
  {path: "", component: AccueilComponent, pathMatch: 'full'},
  {path: "user", component: UserComponent},
  {path: "connection", component: ConnectionComponent},
  {path: "signin", component: SigninComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
