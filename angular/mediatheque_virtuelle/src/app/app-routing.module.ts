import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SigninComponent } from './signin/signin.component';
import { AddMediaComponent } from './add-media/add-media.component';
import { ConnectionComponent } from './connection/connection.component';
import { authGuard } from './auth.guard';
import { AccountComponent } from './account/account.component';
import { AccueilComponent } from './accueil/accueil.component';
import { forceToDisconnectGuard } from './force-to-disconnect.guard';
import { MyAccountComponent } from './my-account/my-account.component';
import { PersoListComponent } from './perso-list/perso-list.component';
import { PersonnalizedListComponent } from './personnalizedList/personnalizedList.component';
import { WatchMediaComponent } from './watch-media/watch-media.component';
import { SeeMediaDetailsComponent } from './see-media-details/see-media-details.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
  { path: "", component: AccueilComponent, pathMatch: 'full' },
  { path: "account", component: AccountComponent, canActivate: [authGuard] },
  { path: "connection", component: ConnectionComponent, canActivate: [forceToDisconnectGuard] },
  { path: "signin", component: SigninComponent, canActivate: [forceToDisconnectGuard] },
  { path: "media/add", component: AddMediaComponent, canActivate: [authGuard] },
  { path: "perso-list", component: PersoListComponent, canActivate: [authGuard] },
  { path: "myAccount", component: MyAccountComponent, canActivate: [authGuard] },
  { path: "personnalizedList", component: PersonnalizedListComponent, canActivate: [authGuard] },
  { path: "watchMedia", component: WatchMediaComponent },
  { path: "media/details/:id", component: SeeMediaDetailsComponent },
  { path: 'search', component: SearchComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
