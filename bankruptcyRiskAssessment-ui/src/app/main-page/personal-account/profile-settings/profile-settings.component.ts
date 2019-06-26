import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../service/user.service";
import {User} from "../../../model/User";

@Component({
  selector: 'app-profile-settings',
  templateUrl: './profile-settings.component.html',
  styleUrls: ['./profile-settings.component.css']
})
export class ProfileSettingsComponent implements OnInit {

  public firsName: string;
  public lastName: string;
  public login: string;
  public phone: string;
  public email: string;
  public password: string;
  public rePassword: string;

  public passwordError: string;
  public emailError: string;
  public loginError: string;

  constructor(
    private userService: UserService) {
    this.currentUser = userService.getCurrentUser();
    this.firsName = this.currentUser.firstName;
    this.lastName = this.currentUser.lastName;
    this.phone = this.currentUser.phone;
    this.login = this.currentUser.login;
    this.email = this.currentUser.eMail;
  }


  private EMAIL_REGEXP = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  private PASSWORD_REGEXP = /^(([A-Za-z0-9]|[.,_]|-){6,16})$/;
  private LOGIN_REGEXP = /^(([A-Za-z0-9]|[.,_]|-){6,16})$/;
  private currentUser: User;
  ngOnInit() {
  }

  validEmail() {
    this.emailError = this.EMAIL_REGEXP.test(this.email) ? '' : 'Неправельний формат електронної пошти';
    if (!this.email)
      this.emailError = '';
  }
  validLogin() {
    this.loginError = this.LOGIN_REGEXP.test(this.login) ? '' : 'Неправельний формат логіну';
    if (!this.login)
      this.loginError = '';
  }
  validPassword() {
    this.passwordError = this.PASSWORD_REGEXP.test(this.password) ? '' : 'Неправельний формат пароля' ;
    if (!this.password)
      this.passwordError = '';
  }
  validRePassword() {
    if(this.password) {
      if (this.password !== this.rePassword){
        this.passwordError = 'Паролі не співпадають';
        return;
      }
      this.passwordError = '';
      return;
    }
    this.passwordError = 'Введіть пароль';
  }

  sendEditedUser() {
    let editedUser: User = new User();
    editedUser = this.currentUser;
    if (this.firsName) {
      editedUser.firstName = this.firsName;
    }
    if (this.lastName) {
      editedUser.lastName = this.lastName;
    }
    if (this.phone) {
      editedUser.phone = this.phone;
    }
    if (this.login) {
      editedUser.login = this.login;
    }
    if (this.email) {
      editedUser.eMail = this.email;
    }
    if (this.password) {
      editedUser.password = this.password;
    }

    this.userService.editUserHttpRequest(editedUser)
      .then(user => {
          this.emailError = ''; this.password = ''; this.email = ''; this.passwordError = '';
          this.firsName = ''; this.lastName=''; this.phone=''; this.login=''; this.rePassword = '';

          alert('Сохранено'); // Must be rewrited to angular alert
        },
        error => {
          alert('Ошибка сохранения');
          alert(error.message);
        });
  }
}
