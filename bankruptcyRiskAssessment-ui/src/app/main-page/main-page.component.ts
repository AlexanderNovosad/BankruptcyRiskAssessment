import { Component, OnInit } from '@angular/core';
import {User} from '../model/User';
import {UserService} from "../service/user.service";
import {AuthService} from "../service/auth.service";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  currentUser: User;

  constructor(private userService: UserService,
              private authService: AuthService) { }

  ngOnInit() {
    this.currentUser = this.userService.getCurrentUser();
  }

  logout() {
    this.authService.logout();
  }

}
