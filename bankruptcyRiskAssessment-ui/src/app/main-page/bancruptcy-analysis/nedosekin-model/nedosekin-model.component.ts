import { Component, OnInit } from '@angular/core';
import {CompanyService} from "../../../service/company.service";
import {Company} from "../../../model/Company";
import {UserService} from "../../../service/user.service";
import {ExpertAccess} from "../../../model/ExpertAccess";
import {Factor} from "../../../model/Factor";
import {BankruptcyService} from "../../../service/bankruptcy.service";
import {Indicator} from "../../../model/Indicator";
import {QuantitativeIndicator} from "../../../model/QuantitativeIndicator";

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

  public show():void{
    console.log(this.finalQualitativeIndicators);
    console.log(this.finalQuantitativeIndicators);
  }



}
