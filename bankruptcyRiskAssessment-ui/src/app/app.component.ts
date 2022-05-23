import { Component } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {AuthService} from "./service/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  test

  title = 'bankruptcyRiskAssessment';

  constructor(private http: HttpClient, private authService: AuthService){

  }

  ngOnInit(): void {
    this.authService.autologin()
  }

  // search(){
  //   this.http.get()
  // }

}
