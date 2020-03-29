import { Component, OnInit } from '@angular/core';
import {UserService} from '../../service/user.service';
import {User} from '../../model/User';
import {Router} from '@angular/router';
import {Role, roleList} from '../../model/Role';

@Component({
  selector: 'app-personal-account',
  templateUrl: './personal-account.component.html',
  styleUrls: ['./personal-account.component.css']
})
export class PersonalAccountComponent implements OnInit {

  currentUser: User;
  role: String;
  constructor(private userService: UserService) {
    this.currentUser = userService.getCurrentUser();
  }

  ngOnInit() {
  }

}
