import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import {Observable} from 'rxjs';
import {UserService} from './user.service';

@Injectable()
export class UserAccessService implements CanActivate {

  constructor(private userService: UserService,
              private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot,
              state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return new Promise<boolean>(resolve => {
      this.userService.loginUserEvent.subscribe(user => {
        if  (user) {
          resolve(true);
        } else {
          this.router.navigateByUrl('home/auth/login');
          resolve(false);
        }
      });
    });
  }
}
