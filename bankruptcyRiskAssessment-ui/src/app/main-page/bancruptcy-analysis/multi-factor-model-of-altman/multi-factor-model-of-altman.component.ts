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
import {MultiFactorModelOfAltman} from "../../../model/MultiFactorModelOfAltman";
import {MultiFactorModelOfAltmanData} from "../../../model/MultiFactorModelOfAltmanData";

@Component({
  selector: 'app-multi-factor-model-of-altman',
  templateUrl: './multi-factor-model-of-altman.component.html',
  styleUrls: ['./multi-factor-model-of-altman.component.css']
})
export class MultiFactorModelOfAltmanComponent implements OnInit {

  constructor(private companyService: CompanyService, private userService: UserService, private bancruptcyService: BankruptcyService) { }
  companyList: Company[]=[];
  expertAccessList: ExpertAccess[]=[];
  selectedCompany = 0;
  company: Company = null;
  openResults: boolean = false;
  openCalculation: boolean = false;
  finalResult: MultiFactorModelOfAltman;
  multiFactorModelOfAltmanData: MultiFactorModelOfAltmanData;
  risk: string = null;



  ngOnInit() {
    this.companyService.getExpertCompanies(this.userService.getCurrentUser().userId).then(expertAccessList=>this.expertAccessList=expertAccessList);
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
    this.multiFactorModelOfAltmanData = new MultiFactorModelOfAltmanData();
    this.openResults=false;
    this.openCalculation = true;
    return this.company;
  }

  public calculateMultiFactorModelOfAltman(){
    this.bancruptcyService.calculateMultiFactorModelOfAltman(this.company.companyId, this.multiFactorModelOfAltmanData).then(results=>this.finalResult=results);
    return this.finalResult;
  }

  public getMultiFactorModelOfAltmanData(){
    return this.multiFactorModelOfAltmanData;
  }

  public NextToResults(): void{
    this.openCalculation=false;
    this.openResults=true;
    this.calculateMultiFactorModelOfAltman();
  }

  public getRisk(): string{
    var risk: string = '';
    if(this.finalResult.z<=1.8)
      risk = 'Ймовірність банкрутства є дуже високою';
    if(this.finalResult.z>1.8)
      if(this.finalResult.z<=2.7)
        risk = 'Ймовірність банкрутства є високою';
    if(this.finalResult.z>2.7)
      if(this.finalResult.z<=2.9)
        risk = 'Банкрутство можливе';
    if(this.finalResult.z>3)
      risk = 'Ймовірність банкрутства дуже мала';

    this.risk = risk;
    return this.risk;
  }

  public getFinalResults(): MultiFactorModelOfAltman{
    return this.finalResult;
  }


}

