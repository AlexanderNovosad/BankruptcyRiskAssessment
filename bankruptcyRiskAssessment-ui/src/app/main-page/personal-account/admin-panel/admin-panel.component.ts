import { Component, OnInit } from '@angular/core';
import {UserService} from '../../../service/user.service';
import {User} from '../../../model/User';
import {Router} from '@angular/router';
import {Role, roleList} from '../../../model/Role';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {

  currentUser: User;
  constructor(private userService: UserService) {
    this.currentUser = userService.getCurrentUser();
  }

  ngOnInit() {
  }

}
