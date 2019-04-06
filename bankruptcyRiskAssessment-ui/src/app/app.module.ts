import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from "@angular/common/http";
import { TestServiceService } from "./test-service.service";
import { FormsModule } from "@angular/forms";

import { UserService } from './service/user.service';
import { AuthComponent } from './home/auth/auth.component';
import { LoginComponent } from './home/auth/login/login.component';
import { RegistrationComponent } from './home/auth/registration/registration.component';
import { HomeComponent } from './home/home.component';
import { AuthService } from './service/auth.service';
import { AuthAccessService } from './service/auth-access.service';
import { UserAccessService } from './service/user-access.service';
import { MessageService } from './service/message.service';
import { MainPageComponent } from './main-page/main-page.component';
import { PersonalAccountComponent } from './main-page/personal-account/personal-account.component';
import { ProfileSettingsComponent } from './main-page/personal-account/profile-settings/profile-settings.component';
import { MessagesComponent } from './main-page/personal-account/messages/messages.component';
import { CompanyEmployeesComponent } from './main-page/personal-account/company-employees/company-employees.component';
import { ProfileCompanyComponent } from './main-page/personal-account/profile-company/profile-company.component';
import { RecommendationsComponent } from './main-page/personal-account/recommendations/recommendations.component';
import { TestingEmployeesComponent } from './main-page/testing-employees/testing-employees.component';
import { TestingFormComponent } from './main-page/testing-employees/testing-form/testing-form.component';
import { TestComponent } from './main-page/testing-employees/testing-form/test/test.component';
import { TestResultComponent } from './main-page/testing-employees/test-result/test-result.component';
import { TestReviewComponent } from './main-page/testing-employees/test-review/test-review.component';
import { BancruptcyAnalysisComponent } from './main-page/bancruptcy-analysis/bancruptcy-analysis.component';
import { ManualInputFormComponent } from './main-page/bancruptcy-analysis/manual-input-form/manual-input-form.component';
import { DocumentFormComponent } from './main-page/bancruptcy-analysis/document-form/document-form.component';
import { OverallRatingOfEnterprisesComponent } from './main-page/overall-rating-of-enterprises/overall-rating-of-enterprises.component';
import { StatisticsComponent } from './main-page/statistics/statistics.component';
import { BancruptcyStatisticsComponent } from './main-page/statistics/bancruptcy-statistics/bancruptcy-statistics.component';
import { LiquidityStatisticsComponent } from './main-page/statistics/liquidity-statistics/liquidity-statistics.component';
import { FinancialEnterpriseAnalysisComponent } from './main-page/financial-enterprise-analysis/financial-enterprise-analysis.component';
import { LiquidityAnalysisComponent } from './main-page/financial-enterprise-analysis/liquidity-analysis/liquidity-analysis.component';



@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    PersonalAccountComponent,
    ProfileSettingsComponent,
    MessagesComponent,
    CompanyEmployeesComponent,
    ProfileCompanyComponent,
    RecommendationsComponent,
    TestingEmployeesComponent,
    TestingFormComponent,
    TestComponent,
    TestResultComponent,
    TestReviewComponent,
    BancruptcyAnalysisComponent,
    ManualInputFormComponent,
    DocumentFormComponent,
    OverallRatingOfEnterprisesComponent,
    StatisticsComponent,
    BancruptcyStatisticsComponent,
    LiquidityStatisticsComponent,
    FinancialEnterpriseAnalysisComponent,
    LiquidityAnalysisComponent,
    AuthComponent,
    LoginComponent,
    RegistrationComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    HttpModule,
    FormsModule
  ],
  providers: [
    TestServiceService,
    UserService,
    AuthAccessService,
    UserAccessService,
    AuthService,
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
