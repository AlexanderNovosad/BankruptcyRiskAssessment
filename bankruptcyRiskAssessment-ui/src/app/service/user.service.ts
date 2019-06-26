import { Injectable } from '@angular/core';
import {User} from '../model/User';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { map } from 'rxjs/operators';
import {ReplaySubject} from 'rxjs';
import {Role} from "../model/Role";

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

  public getRole(roleId: number): Promise<Role> {
    return this.httpClient.get<Role>(`/api/roles/role?role_id=${roleId}`)
      .toPromise().then(response => response as Role);
  }

  private getUsersByRoleIdHttpRequest(roleId: number): Promise<User[]> {
    return this.httpClient.get<User[]>(`/api/user/role?role_id=${roleId}`).toPromise();
  }

  public getUsers(): Promise<User[]> {
    return this.httpClient.get<User[]>(`/api/user/user_list`).toPromise();
  }

}
