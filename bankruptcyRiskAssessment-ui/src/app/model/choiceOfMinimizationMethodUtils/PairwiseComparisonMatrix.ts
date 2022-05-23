export class PairwiseComparisonMatrix {
  pairwiseComparisonMatrixId: number;
  pairwiseComparisonMatrixName: string;
  comparisonItems: any[];
  comparisonItemsMatrix: number[][];
  comparisonItemsVector: number[];
  matrixEigenvalue: number;
  uniformityIndex: number;
  uniformityRatio: number;

  constructor(a: number){
    this.comparisonItemsVector = Array(a).fill(1);
    this.comparisonItems = [];
    this.comparisonItemsMatrix = Array(a).fill(0).map(() => Array(a).fill(0));
    this.matrixEigenvalue = 1;
    this.uniformityIndex = 1;
    this.uniformityRatio = 1;
  }
}
