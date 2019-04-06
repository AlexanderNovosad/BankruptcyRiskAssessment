import { Injectable } from '@angular/core';
import {User} from '../model/User';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/toPromise';
import {ReplaySubject} from 'rxjs';

@Injectable()
export class UserService {

  constructor(private httpClient: HttpClient) {
    this._loginUserEvent = new ReplaySubject(1);
    this._loginUserEvent.subscribe(
      value => this._currentUser = value,
      error => console.log(error)
    );
  }

  private _currentUser: User;
  _loginUserEvent: ReplaySubject<User>;

  public getCurrentUser(): User {
    return this._currentUser;
  }

  get loginUserEvent(): ReplaySubject<User> {
    return this._loginUserEvent;
  }

  public editUserHttpRequest(user: User): Promise<User> {
    return this.httpClient.put(`/api/user`, user)
      .toPromise().then(data => data as User);
  }

}
