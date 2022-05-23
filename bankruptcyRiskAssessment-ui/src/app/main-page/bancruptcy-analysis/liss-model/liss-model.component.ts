import { Component, OnInit } from '@angular/core';
import {CompanyService} from "../../../service/company.service";
import {Company} from "../../../model/Company";
import {UserService} from "../../../service/user.service";
import {ExpertAccess} from "../../../model/ExpertAccess";
import {BankruptcyService} from "../../../service/bankruptcy.service";
import {LissModel} from "../../../model/LissModel";
import {LissModelData} from "../../../model/LissModelData";

@Component({
  selector: 'app-liss-model',
  templateUrl: './liss-model.component.html',
  styleUrls: ['./liss-model.component.css']
})
export class  LissModelComponent implements OnInit {

  constructor(private companyService: CompanyService, private userService: UserService, private bancruptcyService: BankruptcyService) { }
  companyList: Company[]=[];
  expertAccessList: ExpertAccess[]=[];
  selectedCompany = 0;
  company: Company = null;
  openResults: boolean = false;
  openCalculation: boolean = false;
  finalResult:  LissModel;
  lissModelData: LissModelData;
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
    this.lissModelData = new LissModelData();
    this.openResults=false;
    this.openCalculation = true;
    return this.company;
  }

  public calculateLissModel(){
    this.bancruptcyService.calculateLissModel(this.company.companyId, this.lissModelData).then(results=>this.finalResult=results);
    return this.finalResult;
  }

  public getLissModelData(){
    return this.lissModelData;
  }

  public NextToResults(): void{
    this.openCalculation=false;
    this.openResults=true;
    this.calculateLissModel();
  }

  public getRisk(): string{
    var risk: string = '';
    if(this.finalResult.z<0.037)
      risk = 'Загроза банкрутства існує';
    if(this.finalResult.z>=0.037)
      risk = 'Загрози банкрутства немає';
    this.risk = risk;
    return this.risk;
  }

  public getFinalResults(): LissModel{
    return this.finalResult;
  }


}
