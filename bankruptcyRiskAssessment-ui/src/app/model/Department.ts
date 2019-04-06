import {User} from "./User";
import {Company} from "./Company";

export class Department {
  departmentId: number;
  company: Company;
  name: string;
  headOfDepartment: User;
  eMail: string;
  phone: number;

}
