import {User} from "./user/User";
import {Company} from "./Company";

export class Department {
  departmentId: number;
  company: Company;
  name: string;
  headOfDepartment: User;
  email: string;
  phone: string;
}
