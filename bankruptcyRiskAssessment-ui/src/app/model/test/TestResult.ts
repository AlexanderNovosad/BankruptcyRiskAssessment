import {Test} from "./";
import {User} from "../user/User";

export class TestResult {
  testResultId: number;
  test: Test;
  user: User;
  points: number;
}
