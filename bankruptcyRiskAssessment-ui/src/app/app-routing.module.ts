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
import {MultiFactorModelOfAltman} from "./model/MultiFactorModelOfAltman";
import {MultiFactorModelOfAltmanComponent} from "./main-page/bancruptcy-analysis/multi-factor-model-of-altman/multi-factor-model-of-altman.component";
import {LissModelComponent} from "./main-page/bancruptcy-analysis/liss-model/liss-model.component";
import {ProfileSettingsComponent} from "./main-page/personal-account/profile-settings/profile-settings.component";
import {ProfileCompanyComponent} from "./main-page/personal-account/profile-company/profile-company.component";
import {MessagesComponent} from "./main-page/personal-account/messages/messages.component";
// import {CompanyRegistrationComponent} from "./main-page/personal-account/profile-company/company-registration/company-registration.component";
import {RecommendationsComponent} from "./main-page/personal-account/recommendations/recommendations.component";


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
          {path: 'nedosekin-model', component: NedosekinModelComponent},
          {path: 'multi-factor-model-of-altman', component: MultiFactorModelOfAltmanComponent},
          {path: 'liss-model', component: LissModelComponent}

        ]},
      {path: 'financial-enterprise-analysis', component: FinancialEnterpriseAnalysisComponent},
      {path: 'overall-rating-of-enterprises', component: OverallRatingOfEnterprisesComponent},
      {path: 'personal-account', component: PersonalAccountComponent, children:[
          {path: 'statistics', component: StatisticsComponent},
          {path: 'profile-settings', component: ProfileSettingsComponent},
          {path: 'profile-company', component: ProfileCompanyComponent},
          {path: 'messages', component: MessagesComponent},
          {path: 'recommendations', component: RecommendationsComponent},
        ]},
      {path: 'testing-employees', component: TestingEmployeesComponent}
    ]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
