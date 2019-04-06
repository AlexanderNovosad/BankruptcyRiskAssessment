import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpModule} from '@angular/http';
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
import {AuthService} from './service/auth.service';
import {AuthAccessService} from './service/auth-access.service';
import {UserAccessService} from './service/user-access.service';
import {MessageService} from './service/message.service';


@NgModule({
  declarations: [
    AppComponent,
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
