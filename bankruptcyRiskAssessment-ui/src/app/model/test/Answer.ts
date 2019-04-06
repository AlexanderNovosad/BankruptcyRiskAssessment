import {Test} from "./Test";
import {Question} from "./Question";
import {User} from "../User";

export class Answer {
  answerId: number;
  test: Test;
  question: Question;
  user: User;
  answerText: string;
  confirmed: boolean;
}
