import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import { map } from 'rxjs/operators';
import {User} from '../model/User';
import {Http, Response, RequestOptions, Headers} from '@angular/http';
import {Router} from '@angular/router';
import {UserService} from './user.service';

@Injectable()
export class AuthService {

  constructor(private _router: Router,
              private userService: UserService,
              private _http: Http,
              private httpClient: HttpClient) {}

  headers = new Headers({'content-type': 'application/json'});
  options = new RequestOptions({withCredentials: true, headers: this.headers});

  login(user: LoginData): Promise<Response> {
    const promise = this._http.post(`/api/login`, JSON.stringify(user), this.options).toPromise();

    promise.then(value => {
      this.userService.loginUserEvent.next(value.json());
    })
      .catch(error => console.log('[USER_SERVICE]: ' + error)).then(value => console.log("getIt"));
    return promise;
  }

  public createNewUser(newUser: User) {
    return this.httpClient.post<User>('/api/registration', newUser)
      .subscribe(
        res => {
          this.userService.loginUserEvent.next(res);
          this._router.navigateByUrl('');
        },
        err => {
          console.log('Error occured');
        }
      );
  }

  logout(): Promise<Response> {
    const promise = this._http.post(`/api/logout`, {}, this.options).toPromise();

    promise.then(
      value => {
        this.userService.loginUserEvent.next(null);
        this._router.navigateByUrl('home/auth/login');
      }, error => console.log(error));
    return promise;
  }

  autologin() {
    const options = new RequestOptions({withCredentials: true});
    const promise = this._http.get(`/api/autologin`, options).toPromise();
    promise.then(
      value => {
        if (value.text() !== '{}') {
          const user: User = value.json();
          this.userService._loginUserEvent.next(user);
        } else {
          this.userService._loginUserEvent.next(null);
        }
      }, error => console.log(error));
    return promise;
  }
}

class LoginData {
  login: string;
  password: string;
}
