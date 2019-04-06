import {Role} from "./Role";

export class User {
  userId: number;
  lastName: string;
  login: string;
  password: string;
  email: string;
  phone: string;
  department;
  role: Role;
}
