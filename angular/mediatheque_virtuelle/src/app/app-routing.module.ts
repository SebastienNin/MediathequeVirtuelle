import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { SigninComponent } from './signin/signin.component';

const routes: Routes = [
  {path: "user", component: UserComponent},
  {path: "signin", component: SigninComponent},
  {path: "connexion", component: ConnexionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
