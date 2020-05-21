import { Pipe, PipeTransform } from '@angular/core';
import {User} from '../../model/User';

@Pipe({
  name: 'filterUserList'
})
export class FilterUserListPipe implements PipeTransform {

  transform(userList: User[], searchBy: string): any {
    if (searchBy) {
      searchBy = searchBy.toLocaleUpperCase();
      return userList.filter(
        user => (user.firstName.toLocaleUpperCase().match(searchBy)) ||
          (user.lastName.toLocaleUpperCase().match(searchBy)) ||
          (user.email.toLocaleUpperCase().match(searchBy)) ||
          (user.login.toLocaleUpperCase().match(searchBy)));
    } else {
      return userList;
    }
  }
}
