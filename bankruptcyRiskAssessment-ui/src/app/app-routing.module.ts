import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './home/auth/login/login.component';
import {UserAccessService} from './service/user-access.service';
import {AuthComponent} from './home/auth/auth.component';
import {RegistrationComponent} from './home/auth/registration/registration.component';
import {AuthAccessService} from './service/auth-access.service';
import {HomeComponent} from "./home/home.component";
import {MainPageComponent} from "./main-page/main-page.component";
import {BancruptcyAnalysisComponent} from "./main-page/bancruptcy-analysis/bancruptcy-analysis.component";
import {FinancialEnterpriseAnalysisComponent} from "./main-page/financial-enterprise-analysis/financial-enterprise-analysis.component";
import {OverallRatingOfEnterprisesComponent} from "./main-page/overall-rating-of-enterprises/overall-rating-of-enterprises.component";
import {PersonalAccountComponent} from "./main-page/personal-account/personal-account.component";
import {StatisticsComponent} from "./main-page/statistics/statistics.component";
import {TestingEmployeesComponent} from "./main-page/testing-employees/testing-employees.component";
import {NedosekinModelComponent} from "./main-page/bancruptcy-analysis/nedosekin-model/nedosekin-model.component";


const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent, canActivate: [AuthAccessService], children: [
      {path: 'auth', component: AuthComponent, children: [
          {path: '', redirectTo: 'login', pathMatch: 'full'},
          {path: 'login', component: LoginComponent},
          {path: 'registration', component: RegistrationComponent},
          {path: '**', redirectTo: 'login', pathMatch: 'full'}
          ]}
    ]},
  {path: 'main-page', component: MainPageComponent, canActivate: [UserAccessService], children:[
      {path: 'bancruptcy-analysis', component: BancruptcyAnalysisComponent, children: [
          {path: 'nedosekin-model', component: NedosekinModelComponent}

        ]},
      {path: 'financial-enterprise-analysis', component: FinancialEnterpriseAnalysisComponent},
      {path: 'overall-rating-of-enterprises', component: OverallRatingOfEnterprisesComponent},
      {path: 'personal-account', component: PersonalAccountComponent},
      {path: 'statistics', component: StatisticsComponent},
      {path: 'testing-employees', component: TestingEmployeesComponent}
    ]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
