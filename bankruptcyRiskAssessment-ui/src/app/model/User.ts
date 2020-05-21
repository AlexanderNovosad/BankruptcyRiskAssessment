import {Role} from './Role';
import {Department} from "./Department";


export class User {
  userId: number;
  firstName: string;
  lastName: string;
  login: string;
  password: string;
  email: string;
  phone: string;
  department: Department;
  role: Role;
  // confirm: boolean;


}
