import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './home/auth/login/login.component';
import {UserAccessService} from './service/user-access.service';
import {AuthComponent} from './home/auth/auth.component';
import {RegistrationComponent} from './home/auth/registration/registration.component';
import {AuthAccessService} from './service/auth-access.service';
import {HomeComponent} from "./home/home.component";


const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent, children: [
      {path: 'auth', component: AuthComponent, canActivate: [AuthAccessService], children: [
          {path: '', redirectTo: 'login', pathMatch: 'full'},
          {path: 'login', component: LoginComponent},
          {path: 'registration', component: RegistrationComponent},
          {path: '**', redirectTo: 'login', pathMatch: 'full'}
          ]}
    ]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
