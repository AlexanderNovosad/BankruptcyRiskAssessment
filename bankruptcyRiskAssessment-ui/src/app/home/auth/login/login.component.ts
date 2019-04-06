import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService: AuthService) { }
  errorMassage = "";

  ngOnInit() {

  }

  public login(login: string, password: string) {
    this.authService.login({login, password}).catch(error => this.errorMassage = "Вы ввели неправильную электронную почту или пароль");
  }
}
