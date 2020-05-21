import { Component, OnInit } from '@angular/core';
import {CompanyService} from "../../../service/company.service";
import {Company} from "../../../model/Company";
import {UserService} from "../../../service/user.service";
import {ExpertAccess} from "../../../model/ExpertAccess";
import {Factor} from "../../../model/Factor";
import {BankruptcyService} from "../../../service/bankruptcy.service";
import {Indicator} from "../../../model/Indicator";
import {QuantitativeIndicator} from "../../../model/QuantitativeIndicator";
import {PreQuantitativeIndicator} from "../../../model/PreQuantitativeIndicator";
import {LinguisticAssessment} from "../../../model/LinguisticAssessment";
import {assessments} from "../../../model/LinguisticAssessment";

@Component({
  selector: 'app-nedosekin-model',
  templateUrl: './nedosekin-model.component.html',
  styleUrls: ['./nedosekin-model.component.css']
})
export class NedosekinModelComponent implements OnInit {

  constructor(private companyService: CompanyService, private userService: UserService, private bancruptcyService: BankruptcyService) { }
  companyList: Company[]=[];
  expertAccessList: ExpertAccess[]=[];
  selectedCompany = 0;
  company: Company = null;
  factorList: Factor[]=[];
  qualitativeIndicators: Indicator[]=[];
  quantitativeIndicators: QuantitativeIndicator[]=[];
  finalQualitativeIndicators: Indicator[]=[];
  finalQuantitativeIndicators: QuantitativeIndicator[]=[];
  preQuantitativeIndicators: PreQuantitativeIndicator[]=[];
  openIndicatorsSelect: boolean = false;
  openQualitativeIndicatorsCalculation: boolean = false;
  openIndicatorsPointsSets: boolean = false;
  openResults: boolean = false;
  openAssessments: boolean = false;
  allIndicators: Indicator[]=[];
  assessments: LinguisticAssessment[]=[];
  productionIndicators: Indicator[]=[];
  productionDependecies: String[]=[];
  managementIndicators: Indicator[]=[];
  managementDependecies: String[]=[];
  financialIndicators: Indicator[]=[];
  financialDependecies: String[]=[];
  personnelIndicators: Indicator[]=[];
  personnelDependecies: String[]=[];
  marketingIndicators: Indicator[]=[];
  marketingDependecies: String[]=[];
  innovationIndicators: Indicator[]=[];
  innovationDependecies: String[]=[];
  bancruptcyIndicators: BancruptcyIndicator[]=[];
  bancruptcyFactors: BancruptcyFactor[]=[];
  indicators: [Indicator[]];
  dependencies: [String[]];
  factorsDependencies: String[];
  finalResult: Factor[]=[];
  risk: string = '';



  ngOnInit() {
    this.companyService.getCompanies(this.userService.getCurrentUser().userId).then(expertAccessList=>this.expertAccessList=expertAccessList);
    // this.companyService.getAllCompanies().then(companyList=>this.companyList=companyList);
  }

  public getCompanyList(): Company[] {
    this.companyList = [];
    this.expertAccessList.forEach(expertAccess=>this.companyList.push(expertAccess.company));
    return this.companyList;
  }

  public getSelectedCompany(): Company{
    this.companyService.getCompanyById(this.selectedCompany).then(company=>this.company=company);
    console.log(this.company);
    this.bancruptcyService.getFactors().then(factorList=>this.factorList=factorList);
    console.log(this.factorList);
    this.createQuantitativeIndicators();
    console.log(this.quantitativeIndicators);
    this.createQualitativeIndicators();
    console.log(this.qualitativeIndicators);
    this.openIndicatorsSelect = true;
    return this.company;
  }

  public getFactors(): Factor[]{
    return this.factorList;
  }
  public getQualitativeIndicators(): Indicator[]{
    return this.qualitativeIndicators;
  }
  public getQuantitativeIndicators(): QuantitativeIndicator[]{
    return this.quantitativeIndicators;
  }

  public getFinalQuantitativeIndicators(): QuantitativeIndicator[]{
    return this.finalQuantitativeIndicators;
  }

  public getFinalQualitativeIndicators(): Indicator[]{
    return this.finalQualitativeIndicators;
  }

  public getAssessments(): LinguisticAssessment[]{
    return assessments;
  }

  public createQualitativeIndicators(): Indicator[]{
    this.bancruptcyService.getQualitativeIndicators().then(indicators=>this.qualitativeIndicators=indicators);
    return this.qualitativeIndicators;
  }

  public createQuantitativeIndicators(): QuantitativeIndicator[]{
    this.bancruptcyService.getQuantitativeIndicators().then(indicators=>this.quantitativeIndicators=indicators);
    return this.quantitativeIndicators;
  }

  public checkQualitativeIndicators(indicator: Indicator): void{
    if(this.finalQualitativeIndicators.includes(indicator)){
      this.finalQualitativeIndicators.splice(this.finalQualitativeIndicators.indexOf(indicator),1);
    }
    else this.finalQualitativeIndicators.push(indicator);
  }

  public checkQuantitativeIndicators(indicator: QuantitativeIndicator): void{
    if(this.finalQuantitativeIndicators.includes(indicator)){
      this.finalQuantitativeIndicators.splice(this.finalQualitativeIndicators.indexOf(indicator),1);
    }
    else this.finalQuantitativeIndicators.push(indicator);
  }

  public createPreQuantitativeIndicators(){
    this.preQuantitativeIndicators=[];
    console.log(this.finalQuantitativeIndicators);
    this.bancruptcyService.getPreQuantitativeIndicators(this.finalQuantitativeIndicators).then(preQuantitativeIndicators=>this.preQuantitativeIndicators=preQuantitativeIndicators);
    console.log(this.preQuantitativeIndicators);
    return this.preQuantitativeIndicators;
  }

  public getPreQuantitativeIndicators(): PreQuantitativeIndicator[]{
    return this.preQuantitativeIndicators;
  }

  public calculateAmountOfQuantitativeIndicators(){
    this.bancruptcyService.calculateAmountOfQuantitativeIndicators(this.finalQuantitativeIndicators,this.preQuantitativeIndicators).then(quantitativeIndicator=>this.finalQuantitativeIndicators=quantitativeIndicator);
    return this.finalQuantitativeIndicators;
  }

  public setTheAssessments(getAssessment: string): LinguisticAssessment{
    console.log(getAssessment);
    return this.getAssessments().find(assessment=>getAssessment==assessment.name);
    // this.bancruptcyService.setTheAssessments(this.allIndicators, this.assessments).then(indicators=>this.allIndicators=indicators);
    // return this.allIndicators;
  }

  public calculateBankruptcyPoints(){
    this.preCalculateBankruptcyPoints();
    console.log(this.indicators);
    console.log(this.dependencies);
    console.log(this.factorsDependencies);
    this.bancruptcyService.calculateBankruptcyPoints(this.company.companyId, this.indicators,this.dependencies,this.factorsDependencies).then(results=>this.finalResult=results);
    return this.finalResult;
  }

  public getRisk(): string{
    var risk: string = '';
    for(var i=0;i<this.finalResult.length;i++){
      if(this.finalResult[i].name.startsWith("Стан підприємства")){
        if(this.finalResult[i].assessment.name.startsWith("Дуже низький"))
          risk = this.finalResult[i].assessment.name.replace("Дуже низький","Позаграничний");
        if(this.finalResult[i].assessment.name.startsWith("Низький"))
          risk = this.finalResult[i].assessment.name.replace("Низький","Небезпечний");
        if(this.finalResult[i].assessment.name.startsWith("Середній"))
          risk = this.finalResult[i].assessment.name.replace("Середній","Граничний");
        if(this.finalResult[i].assessment.name.startsWith("Високий"))
          risk = this.finalResult[i].assessment.name.replace("Високий","Прийнятний");
        if(this.finalResult[i].assessment.name.startsWith("Дуже високий"))
          risk = this.finalResult[i].assessment.name.replace("Дуже високий","Незначний");
      }
    }
    this.risk = risk;
    return this.risk;
  }

  public getFinalResults(): Factor[]{
    return this.finalResult;
  }

  public nextToQualitativeIndicatorsCalculation():void{
    console.log(this.finalQualitativeIndicators);
    console.log(this.finalQuantitativeIndicators);
    this.createPreQuantitativeIndicators();
    this.openIndicatorsSelect=false;
    this.openQualitativeIndicatorsCalculation=true;
  }

  public backToIndicatorsSelect(): void{
    this.preQuantitativeIndicators=[];
    this.openIndicatorsSelect=true;
    this.openQualitativeIndicatorsCalculation=false;
  }

  public NextToIndicatorsPointsSets(): void{
    this.openQualitativeIndicatorsCalculation=false;
    this.openIndicatorsPointsSets=true;
    this.calculateAmountOfQuantitativeIndicators();
  }

  public saveAssessments(): void{
    this.concatIndicators();
    // this.setTheAssessments();
    this.createBancruptcyFactors();
    this.createBancruptcyIndicators();
    this.openAssessments=true;
    console.log(this.allIndicators);
  }

  public backToQualitativeIndicatorsCalculation(): void{
    this.allIndicators=[];
    this.openQualitativeIndicatorsCalculation=true;
    this.openIndicatorsPointsSets=false;
    this.openAssessments=false;
  }

  public NextToResults(): void{
    this.openIndicatorsPointsSets=false;
    this.openResults=true;
    console.log(this.bancruptcyIndicators);
    this.calculateBankruptcyPoints();
  }

  public backToIndicatorsPointsSets(): void{
    this.openIndicatorsPointsSets=true;
    this.openResults=false;
  }

  public concatIndicators(): void{
    this.allIndicators = this.finalQualitativeIndicators.concat(this.finalQuantitativeIndicators);
    this.allIndicators.sort((leftSide,rightSide): number=>{
      if(leftSide.factor.name < rightSide.factor.name) return -1;
      if(leftSide.factor.name < rightSide.factor.name) return 1;
      return 0;
    })
  }

  public createBancruptcyFactors(){
    this.bancruptcyFactors=[];
    this.getFactors().forEach(factor=>this.bancruptcyFactors.push(new BancruptcyFactor(factor)));
    this.bancruptcyFactors[this.bancruptcyFactors.length-1].dependence = 'пуст';
  }

  public getBancruptcyFactors(): BancruptcyFactor[]{
    return this.bancruptcyFactors;
  }

  public splitIndicators(){
    for(var i=0;i<this.allIndicators.length;i++){
      if(this.allIndicators[i].factor.name=='Виробничий фактор'){
        this.productionIndicators.push(this.allIndicators[i]);
        this.productionDependecies.push('=');
      }
      if(this.allIndicators[i].factor.name=='Управлінський фактор'){
        this.managementIndicators.push(this.allIndicators[i]);
        this.managementDependecies.push('=');
      }
      if(this.allIndicators[i].factor.name=='Фінансовий фактор'){
        this.financialIndicators.push(this.allIndicators[i]);
        this.financialDependecies.push('=');
      }
      if(this.allIndicators[i].factor.name=='Кадровий фактор'){
        this.personnelIndicators.push(this.allIndicators[i]);
        this.personnelDependecies.push('=');
      }
      if(this.allIndicators[i].factor.name=='Маркетинговий фактор'){
        this.marketingIndicators.push(this.allIndicators[i]);
        this.marketingDependecies.push('=');
      }
      if(this.allIndicators[i].factor.name=='Інноваційний фактор'){
        this.innovationIndicators.push(this.allIndicators[i]);
        this.innovationDependecies.push('=');
      }
    }
  }

  public createBancruptcyIndicators(){
    this.bancruptcyIndicators = [];
    for(var i=0;i<this.allIndicators.length;i++){
      var bancruptcyIndicator = new BancruptcyIndicator(this.allIndicators[i]);
        this.bancruptcyIndicators.push(bancruptcyIndicator);
    }
    // this.bancruptcyIndicators = []; *ngIf="bancruptcyIndicator.dependence!=='пуст'"
    // this.splitIndicators();
    // if(this.productionIndicators!=null){
    //   var bancruptcyIndicators = new BancruptcyIndicators(this.productionIndicators,this.productionDependecies);
    //   this.bancruptcyIndicators.push(bancruptcyIndicators);
    // }
    // if(this.managementIndicators!=null){
    //   var bancruptcyIndicators = new BancruptcyIndicators(this.managementIndicators,this.managementDependecies);
    //   this.bancruptcyIndicators.push(bancruptcyIndicators);
    // }
    // if(this.financialIndicators!=null){
    //   var bancruptcyIndicators = new BancruptcyIndicators(this.financialIndicators,this.financialDependecies);
    //   this.bancruptcyIndicators.push(bancruptcyIndicators);
    // }
    // if(this.personnelIndicators!=null){
    //   var bancruptcyIndicators = new BancruptcyIndicators(this.personnelIndicators,this.personnelDependecies);
    //   this.bancruptcyIndicators.push(bancruptcyIndicators);
    // }
    // if(this.marketingIndicators!=null){
    //   var bancruptcyIndicators = new BancruptcyIndicators(this.marketingIndicators,this.marketingDependecies);
    //   this.bancruptcyIndicators.push(bancruptcyIndicators);
    // }
    // if(this.innovationIndicators!=null){
    //   var bancruptcyIndicators = new BancruptcyIndicators(this.innovationIndicators,this.innovationDependecies);
    //   this.bancruptcyIndicators.push(bancruptcyIndicators);
    // }
  }

  public getBancruptcyIndicators(): BancruptcyIndicator[]{
    return this.bancruptcyIndicators;
  }

  public preCalculateBankruptcyPoints(){
    this.productionIndicators=[];
    this.productionDependecies=[];
    this.managementIndicators=[];
    this.managementDependecies=[];
    this.financialIndicators=[];
    this.financialDependecies=[];
    this.personnelIndicators=[];
    this.personnelDependecies=[];
    this.marketingIndicators=[];
    this.marketingDependecies=[];
    this.innovationIndicators=[];
    this.innovationDependecies=[];
    this.indicators=[null];
    this.dependencies=[null];
    this.factorsDependencies=[];
    for(var i=0;i<this.bancruptcyIndicators.length;i++){
      if(this.bancruptcyIndicators[i].indicator.factor.name=='Виробничий фактор'){
        this.productionIndicators.push(this.bancruptcyIndicators[i].indicator);
        this.productionDependecies.push(this.bancruptcyIndicators[i].dependence);
      }
      if(this.bancruptcyIndicators[i].indicator.factor.name=='Управлінський фактор'){
        this.managementIndicators.push(this.bancruptcyIndicators[i].indicator);
        this.managementDependecies.push(this.bancruptcyIndicators[i].dependence);
      }
      if(this.bancruptcyIndicators[i].indicator.factor.name=='Фінансовий фактор'){
        this.financialIndicators.push(this.bancruptcyIndicators[i].indicator);
        this.financialDependecies.push(this.bancruptcyIndicators[i].dependence);
      }
      if(this.bancruptcyIndicators[i].indicator.factor.name=='Кадровий фактор'){
        this.personnelIndicators.push(this.bancruptcyIndicators[i].indicator);
        this.personnelDependecies.push(this.bancruptcyIndicators[i].dependence);
      }
      if(this.bancruptcyIndicators[i].indicator.factor.name=='Маркетинговий фактор'){
        this.marketingIndicators.push(this.bancruptcyIndicators[i].indicator);
        this.marketingDependecies.push(this.bancruptcyIndicators[i].dependence);
      }
      if(this.bancruptcyIndicators[i].indicator.factor.name=='Інноваційний фактор'){
        this.innovationIndicators.push(this.bancruptcyIndicators[i].indicator);
        this.innovationDependecies.push(this.bancruptcyIndicators[i].dependence);
      }
      // this.indicators.push(this.bancruptcyIndicators[i].indicators);
      // this.dependencies.push(this.bancruptcyIndicators[i].dependencies);
    }
    this.productionDependecies.pop();
    this.managementDependecies.pop();
    this.financialDependecies.pop();
    this.personnelDependecies.pop();
    this.marketingDependecies.pop();
    this.innovationDependecies.pop();
    if(this.productionIndicators!=null) this.indicators.push(this.productionIndicators);
    if(this.managementIndicators!=null) this.indicators.push(this.managementIndicators);
    if(this.financialIndicators!=null) this.indicators.push(this.financialIndicators);
    if(this.personnelIndicators!=null) this.indicators.push(this.personnelIndicators);
    if(this.marketingIndicators!=null) this.indicators.push(this.marketingIndicators);
    if(this.innovationIndicators!=null) this.indicators.push(this.innovationIndicators);
    if(this.productionDependecies!=null) this.dependencies.push(this.productionDependecies);
    if(this.managementDependecies!=null) this.dependencies.push(this.managementDependecies);
    if(this.financialDependecies!=null) this.dependencies.push(this.financialDependecies);
    if(this.personnelDependecies!=null) this.dependencies.push(this.personnelDependecies);
    if(this.marketingDependecies!=null) this.dependencies.push(this.marketingDependecies);
    if(this.innovationDependecies!=null) this.dependencies.push(this.innovationDependecies);
    this.indicators.shift();
    this.dependencies.shift();
    for(var i=0;i<this.bancruptcyFactors.length-1;i++){
      this.factorsDependencies.push(this.bancruptcyFactors[i].dependence);
    }
  }

}

class BancruptcyIndicator {
  indicator: Indicator;
  dependence: String;

  constructor(indicator:Indicator){
    this.indicator = indicator;
    this.dependence = '=';
  }
}

class BancruptcyFactor {
  factor: Factor;
  dependence: String;

  constructor(factor:Factor){
    this.factor = factor;
    this.dependence = '=';
  }
}
