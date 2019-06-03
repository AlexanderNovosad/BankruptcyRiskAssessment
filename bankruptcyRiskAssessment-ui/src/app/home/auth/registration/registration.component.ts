import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../../service/auth.service';
import {ActivatedRoute} from '@angular/router';
import {Role, roleList} from '../../../model/Role';
import {UserService} from "../../../service/user.service";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private authService: AuthService, private userService: UserService) { }

  // private role: Role;



  ngOnInit() {
    // this.userService.getRole(1).then(role => this.role = role).then(role => console.log(role));
  }

  public registration(firstName, lastName, login, userEmail, userPassword1, userPassword2, userPhoneNumber) {
    if (userPassword2 === userPassword1) {
      this.authService.createNewUser({
        userId: 0,
        firstName: firstName,
        lastName: lastName,
        login: login,
        password: userPassword1,
        eMail: userEmail,
        role: roleList[1],
        phone: userPhoneNumber,
        department: null
      });
    } else {
      alert('Пароли не совпадают');
    }
  }
}
