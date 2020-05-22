import { Component, OnInit } from '@angular/core';
import {CompanyService} from "../../../service/company.service";
import {Company} from "../../../model/Company";
import {UserService} from "../../../service/user.service";
import {ExpertAccess} from "../../../model/ExpertAccess";
import {BankruptcyService} from "../../../service/bankruptcy.service";
import {DavidBelikovModel} from "../../../model/DavidBelikovModel";
import {DavidBelikovModelData} from "../../../model/DavidBelikovModelData";

@Component({
  selector: 'app-david-belikov-model',
  templateUrl: './david-belikov-model.component.html',
  styleUrls: ['./david-belikov-model.component.css']
})
export class  DavidBelikovModelComponent implements OnInit {

  constructor(private companyService: CompanyService, private userService: UserService, private bancruptcyService: BankruptcyService) { }
  companyList: Company[]=[];
  expertAccessList: ExpertAccess[]=[];
  selectedCompany = 0;
  company: Company = null;
  openResults: boolean = false;
  openCalculation: boolean = false;
  finalResult:  DavidBelikovModel;
  davidBelikovModelData: DavidBelikovModelData;
  risk: string = null;



  ngOnInit() {
    this.companyService.getExpertCompanies(this.userService.getCurrentUser().userId).then(expertAccessList=>this.expertAccessList=expertAccessList);
  }

  public getCompanyList(): Company[] {
    this.companyList = [];
    this.expertAccessList.forEach(expertAccess=>this.companyList.push(expertAccess.company));
    return this.companyList;
  }

  public getSelectedCompany(): Company{
    this.companyService.getCompanyById(this.selectedCompany).then(company=>this.company=company);
    console.log(this.company);
    this.davidBelikovModelData = new DavidBelikovModelData();
    this.openCalculation = true;
    return this.company;
  }

  public calculateDavidBelikovModel(){
    this.bancruptcyService.calculateDavidBelikovModel(this.company.companyId, this.davidBelikovModelData).then(results=>this.finalResult=results);
    return this.finalResult;
  }

  public getDavidBelikovModelData(){
    return this.davidBelikovModelData;
  }

  public NextToResults(): void{
    this.openCalculation=false;
    this.openResults=true;
    this.calculateDavidBelikovModel();
  }

  public getRisk(): string{
    var risk: string = '';
    if(this.finalResult.z<=0)
      risk = 'максимальний ступінь банкрутства 90-100%';
    if(this.finalResult.z>0 && this.finalResult.z<=0.18)
      risk = 'високий ступінь банкрутства 60-80%';
    if(this.finalResult.z>0.18 && this.finalResult.z<=0.32)
      risk = 'середній ступінь банкрутства 35-50%';
    if(this.finalResult.z>0.32 && this.finalResult.z<=0.42)
      risk = 'низький ступінь банкрутства 15-20%';
    if(this.finalResult.z>0.42)
      risk = 'мінімальний ступінь банкрутства 10%';
    this.risk = risk;
    return this.risk;
  }

  public getFinalResults(): DavidBelikovModel{
    return this.finalResult;
  }

}
