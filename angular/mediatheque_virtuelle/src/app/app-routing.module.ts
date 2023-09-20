import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SigninComponent } from './signin/signin.component';
import { ConnectionComponent } from './connection/connection.component';
import { AccountComponent } from './account/account.component';

const routes: Routes = [
  {path: "account", component: AccountComponent},
  {path: "connection", component: ConnectionComponent},
  {path: "signin", component: SigninComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
