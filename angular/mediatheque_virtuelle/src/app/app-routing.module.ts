import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { SigninComponent } from './signin/signin.component';
import { ConnectionComponent } from './connection/connection.component';

const routes: Routes = [
  {path: "user", component: UserComponent},
  {path: "connection", component: ConnectionComponent},
  {path: "signin", component: SigninComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
