import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../data-service/auth.service';
import {ActivatedRoute} from '@angular/router';
import {roleList} from '../../data-service/model/user/Role';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private authService: AuthService) { }

  private role;

  ngOnInit() {
  }

  public registration(userName, userEmail, userPassword1, userPassword2, userPhoneNumber) {
    if (userPassword2 === userPassword1) {
      this.authService.createNewUser({
        userId: 0,
        name: userName,
        eMail: userEmail,
        password: userPassword1,
        phoneNumber: userPhoneNumber,
        role: this.role,
        status: false,
        specialization: null,
        team: null
      });
    } else {
      alert('Пароли не совпадают');
    }
  }
}
