import {TestCategory} from "../test/TestCategory";
import {User} from "../User";

export class UserEfficiencyFactor {
  userEfficiencyFactorId: number;
  user: User;
  testCategory: TestCategory;
  efficiencyFactor: number;
  date: Date;
}
