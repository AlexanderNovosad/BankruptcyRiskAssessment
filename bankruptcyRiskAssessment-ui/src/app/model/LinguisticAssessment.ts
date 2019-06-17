export class LinguisticAssessment {
  name: String;
  a: number;
  b: number;
  c: number;
  d: number;

}

export const assessments: LinguisticAssessment[] = [
  {
    name: 'Дуже низький',
    a: 0,
    b: 0,
    c: 0.15,
    d: 0.25
  }, {
    name: 'Низький',
    a: 0.15,
    b: 0.25,
    c: 0.35,
    d: 0.45
  }, {
    name: 'Середній',
    a: 0.35,
    b: 0.45,
    c: 0.55,
    d: 0.65
  }, {
    name: 'Високий',
    a: 0.55,
    b: 0.65,
    c: 0.75,
    d: 0.85
  }, {
    name: 'Дуже високий',
    a: 0.75,
    b: 0.85,
    c: 1,
    d: 1
  }
];
