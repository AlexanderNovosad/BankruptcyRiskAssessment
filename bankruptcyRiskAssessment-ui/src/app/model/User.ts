import {Role} from './Role';
import {Department} from "./Department";


export class User {
  userId: number;
  firstName: string;
  lastName: string;
  login: string;
  password: string;
  eMail: string;
  role: Role;
  phone: string;
  department: Department;
  confirm: boolean;


}
