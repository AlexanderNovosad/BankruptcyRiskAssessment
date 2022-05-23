import { Component, OnInit } from '@angular/core';
import {User} from "../../model/User";
import {Company} from "../../model/Company";
import {CompanyFactor} from "../../model/CompanyFactor";
import {LissModel} from "../../model/LissModel";
import {DavidBelikovModel} from "../../model/DavidBelikovModel";
import {MultiFactorModelOfAltman} from "../../model/MultiFactorModelOfAltman";
import {SpringateModel} from "../../model/SpringateModel";
import {UniversalDiscriminatoryModel} from "../../model/UniversalDiscriminatoryModel";
import {BankruptcyService} from "../../service/bankruptcy.service";
import {CompanyService} from "../../service/company.service";
import {UserService} from "../../service/user.service";
import {ExpertAccess} from "../../model/ExpertAccess";
import {MessageService} from "../../service/message.service";
import {FactorGoal} from "../../model/choiceOfMinimizationMethodUtils/FactorGoal";
import {Factor} from "../../model/choiceOfMinimizationMethodUtils/Factor";
import {CourseOfEvents} from "../../model/choiceOfMinimizationMethodUtils/CourseOfEvents";
import {PairwiseComparisonMatrix} from "../../model/choiceOfMinimizationMethodUtils/PairwiseComparisonMatrix";

@Component({
  selector: 'app-choice-of-minimization-method',
  templateUrl: './choice-of-minimization-method.component.html',
  styleUrls: ['./choice-of-minimization-method.component.css']
})
export class ChoiceOfMinimizationMethodComponent implements OnInit {

  currentUser: User;
  expertCompanies: Company[];
  expertAccessList: ExpertAccess[]=[];
  nedosekinModelIndicators: CompanyFactor[];
  lissModelIndicators: LissModel[];
  davidBelikovModelIndicators: DavidBelikovModel[];
  multiFactorModelOfAltmanIndicators: MultiFactorModelOfAltman[];
  springateModelIndicators: SpringateModel[];
  universalDiscriminatoryModelIndicators: UniversalDiscriminatoryModel[];
  selectedCompany = 0;
  selectedFactor = 0;
  factorList: Factor[];
  factorGoalList: FactorGoal[];
  courseOfEventsList: CourseOfEvents[];
  pairwiseComparisonMatrixList: PairwiseComparisonMatrix[];
  newPairwiseComparisonMatrix : PairwiseComparisonMatrix;
  openCompanySelection: boolean = true;
  openStage1: boolean = true;
  openStage2: boolean = false;
  openStage3: boolean = false;
  openStage4: boolean = false;
  openStage5: boolean = false;
  openStage6: boolean = false;
  openStage7: boolean = false;
  openStage8: boolean = false;
  openStage9: boolean = false;

  constructor(private bankruptcyService: BankruptcyService, private companyService: CompanyService, private userService: UserService, private messageService: MessageService) {
    this.currentUser = userService.getCurrentUser();
  }

  ngOnInit() {
    this.companyService.getExpertCompanies(this.currentUser.userId).then(expertAccessList=>this.expertAccessList=expertAccessList);
    this.openCompanySelection = true;
    this.openStage1 = true;

  }

  public getExpertCompanies(): Company[] {
    this.expertCompanies = [];
    this.expertAccessList.forEach(expertAccess=>this.expertCompanies.push(expertAccess.company));
    if(this.expertCompanies!=null){
      if(this.expertCompanies.length == 0)
        this.expertCompanies=null;
    }
    return this.expertCompanies;
  }

  public getStatistics(companyId: number){
    if(companyId == 0 && this.expertCompanies != []){
      companyId = this.getExpertCompanies()[0].companyId;
    }
    this.bankruptcyService.getNedosekinModelIndicatorsForCompany(companyId).subscribe(data => this.nedosekinModelIndicators = data);
    this.bankruptcyService.getLissModelIndicatorsForCompany(companyId).subscribe(data => this.lissModelIndicators = data);
    this.bankruptcyService.getDavidBelikovModelIndicatorsForCompany(companyId).subscribe(data => this.davidBelikovModelIndicators = data);
    this.bankruptcyService.getMultiFactorModelOfAltmanIndicatorsForCompany(companyId).subscribe(data => this.multiFactorModelOfAltmanIndicators = data);
    this.bankruptcyService.getSpringateModelIndicatorsForCompany(companyId).subscribe(data => this.springateModelIndicators = data);
    this.bankruptcyService.getUniversalDiscriminatoryModelIndicatorsForCompany(companyId).subscribe(data => this.universalDiscriminatoryModelIndicators = data);
  }

  public createFactor(factorName: string){
    let newFactor = new Factor();
    if(this.factorList!=null){
      newFactor.factorId = this.factorList.length+1;
    }
    else{
      this.factorList = [];
      newFactor.factorId = 1;
    }
    newFactor.name = factorName;
    this.factorList.push(newFactor);
  }

  public getFactors(): Factor[]{
    if(this.factorList!=null){
      if(this.factorList.length == 0)
        this.factorList=null;
    }
    return this.factorList;
  }

  public createFactorGoal(factorGoalName: string, factor: Factor){
    let newFactorGoal = new FactorGoal();
    if(this.factorGoalList!=null){
      newFactorGoal.factorGoalId = this.factorGoalList.length+1;
    }
    else{
      this.factorGoalList = [];
      newFactorGoal.factorGoalId = 1;
    }
    newFactorGoal.name = factorGoalName;
    newFactorGoal.factor = factor;
    this.factorGoalList.push(newFactorGoal);
  }

  public getFactorGoals(): FactorGoal[]{
    if(this.factorGoalList!=null){
      if(this.factorGoalList.length == 0)
        this.factorGoalList=null;
    }
    return this.factorGoalList;
  }

  public createCourseOfEvents(courseOfEventsName: string){
    let newCourseOfEvents = new CourseOfEvents();
    if(this.courseOfEventsList!=null){
      newCourseOfEvents.courseOfEventsId = this.courseOfEventsList.length+1;
    }
    else {
      this.courseOfEventsList = [];
      newCourseOfEvents.courseOfEventsId = 1;
    }
    newCourseOfEvents.name = courseOfEventsName;
    this.courseOfEventsList.push(newCourseOfEvents);
  }

  public getCoursesOfEvents(): CourseOfEvents[]{
    if(this.courseOfEventsList!=null){
      if(this.courseOfEventsList.length == 0)
        this.courseOfEventsList=null;
    }
    return this.courseOfEventsList;
  }

  public calculateFactorMatrix(){
    if(this.pairwiseComparisonMatrixList!=null){
      this.newPairwiseComparisonMatrix.pairwiseComparisonMatrixId = this.pairwiseComparisonMatrixList.length+1;
    }
    else {
      this.pairwiseComparisonMatrixList = [];
      this.newPairwiseComparisonMatrix.pairwiseComparisonMatrixId = 1;
    }
    this.newPairwiseComparisonMatrix.pairwiseComparisonMatrixName = "Фактори";
    this.newPairwiseComparisonMatrix.comparisonItems.push(this.factorList);
    let sum = 0;

    for(var i=0;i<this.factorList.length;i++){
      for(var j=0;j<this.factorList.length;j++){
        this.newPairwiseComparisonMatrix.comparisonItemsVector[j] = this.newPairwiseComparisonMatrix.comparisonItemsVector[j]*this.newPairwiseComparisonMatrix.comparisonItemsMatrix[i][j];
      }
      this.newPairwiseComparisonMatrix.comparisonItemsVector[i] = Math.sqrt(Math.sqrt(this.newPairwiseComparisonMatrix.comparisonItemsVector[i]));
      sum = sum+this.newPairwiseComparisonMatrix.comparisonItemsVector[i];
    }
    for(var i=0;i<this.factorList.length;i++){
      this.newPairwiseComparisonMatrix.comparisonItemsVector[i] = this.newPairwiseComparisonMatrix.comparisonItemsVector[i]/sum;
    }

    let A = Array(this.newPairwiseComparisonMatrix.comparisonItemsVector.length).fill(1);
    var rowsB = this.newPairwiseComparisonMatrix.comparisonItemsMatrix.length, colsB = this.newPairwiseComparisonMatrix.comparisonItemsMatrix[0].length,
      rowsA = A.length, colsA = 1,
      C = [];
    if (colsA != rowsB) return false;
    for (var i = 0; i < rowsA; i++) C[i] = [];
    for (var k = 0; k < colsB; k++)
    { for (var i = 0; i < rowsA; i++)
    { var t = 0;
      for (var j = 0; j < rowsB; j++) t += A[ i ][j]*this.newPairwiseComparisonMatrix.comparisonItemsMatrix[j][k];
      C[i][k] = t;
    }
    }

    var s = 0;
    for(var i=0; i<this.newPairwiseComparisonMatrix.comparisonItemsVector.length; i++){
      s = s+ (C[i]*this.newPairwiseComparisonMatrix.comparisonItemsVector[i]);
    }
    this.newPairwiseComparisonMatrix.matrixEigenvalue = s;

    this.newPairwiseComparisonMatrix.uniformityIndex = 0;
    this.newPairwiseComparisonMatrix.uniformityRatio = 0;
  }


  public toStage2(){
    this.openStage1 = false;
    this.openStage2 = true;
  }

  public toStage3(){
    this.openStage2 = false;
    this.openStage3 = true;
  }

  public toStage4(){
    this.openStage3 = false;
    this.openStage4 = true;
    this.newPairwiseComparisonMatrix = new PairwiseComparisonMatrix(this.factorList.length);
  }

  public toStage5(){
    this.openStage4 = false;
    this.openStage5 = true;
  }

  public toStage6(){
    this.openStage5 = false;
    this.openStage6 = true;
  }

  public toStage7(){
    this.openStage6 = false;
    this.openStage7 = true;
  }

  public toStage8(){
    this.openStage7 = false;
    this.openStage8 = true;
  }

  public toStage9(){
    this.openStage8 = false;
    this.openStage9 = true;
  }


  public getNedosekinModelIndicatorsForCompany(): CompanyFactor[]{
    if(this.nedosekinModelIndicators!=null){
      if(this.nedosekinModelIndicators.length == 0)
        this.nedosekinModelIndicators=null;
    }
    return this.nedosekinModelIndicators;
  }

  public getLissModelIndicatorsForCompany(): LissModel[]{
    if(this.lissModelIndicators!=null){
      if(this.lissModelIndicators.length == 0)
        this.lissModelIndicators=null;
    }
    return this.lissModelIndicators;
  }

  public getDavidBelikovModelIndicatorsForCompany(): DavidBelikovModel[]{
    if(this.davidBelikovModelIndicators!=null){
      if(this.davidBelikovModelIndicators.length == 0)
        this.davidBelikovModelIndicators=null;
    }
    return this.davidBelikovModelIndicators;
  }

  public getMultiFactorModelOfAltmanIndicatorsForCompany(): MultiFactorModelOfAltman[]{
    if(this.multiFactorModelOfAltmanIndicators!=null){
      if(this.multiFactorModelOfAltmanIndicators.length == 0)
        this.multiFactorModelOfAltmanIndicators=null;
    }
    return this.multiFactorModelOfAltmanIndicators;
  }

  public getSpringateModelIndicatorsForCompany(): SpringateModel[]{
    if(this.springateModelIndicators!=null){
      if(this.springateModelIndicators.length == 0)
        this.springateModelIndicators=null;
    }
    return this.springateModelIndicators;
  }

  public getUniversalDiscriminatoryModelIndicatorsForCompany(): UniversalDiscriminatoryModel[]{
    if(this.universalDiscriminatoryModelIndicators!=null){
      if(this.universalDiscriminatoryModelIndicators.length == 0)
        this.universalDiscriminatoryModelIndicators=null;
    }
    return this.universalDiscriminatoryModelIndicators;
  }

  public timestampToDate(timestamp) {
    return new Date(timestamp);
  }

  public findCompany(element: Company, index, array){
    if(element.companyId == this.selectedCompany)
      return element;
  }
}
