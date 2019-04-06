import {Test} from "./Test";
import {User} from "../User";

export class TestResult {
  testResultId: number;
  test: Test;
  user: User;
  points: number;
}
