import {User} from "./User";
import {Company} from "./Company";

export class Recommendation {
  recommendationId: number;
  expert: User;
  company: Company;
  problemDescription: string;
  recommendationDescription: string;
  date: number;
}
