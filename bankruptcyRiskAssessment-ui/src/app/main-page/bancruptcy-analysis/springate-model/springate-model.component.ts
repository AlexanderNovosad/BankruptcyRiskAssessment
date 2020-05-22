import { Component, OnInit } from '@angular/core';
import {CompanyService} from "../../../service/company.service";
import {Company} from "../../../model/Company";
import {UserService} from "../../../service/user.service";
import {ExpertAccess} from "../../../model/ExpertAccess";
import {BankruptcyService} from "../../../service/bankruptcy.service";
import {SpringateModel} from "../../../model/SpringateModel";
import {SpringateModelData} from "../../../model/SpringateModelData";

@Component({
  selector: 'app-springate-model',
  templateUrl: './springate-model.component.html',
  styleUrls: ['./springate-model.component.css']
})
export class  SpringateModelComponent implements OnInit {

  constructor(private companyService: CompanyService, private userService: UserService, private bancruptcyService: BankruptcyService) { }
  companyList: Company[]=[];
  expertAccessList: ExpertAccess[]=[];
  selectedCompany = 0;
  company: Company = null;
  openResults: boolean = false;
  openCalculation: boolean = false;
  finalResult:  SpringateModel;
  springateModelData: SpringateModelData;
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
    this.springateModelData = new SpringateModelData();
    this.openCalculation = true;
    return this.company;
  }

  public calculateSpringateModel(){
    this.bancruptcyService.calculateSpringateModel(this.company.companyId, this.springateModelData).then(results=>this.finalResult=results);
    return this.finalResult;
  }

  public getSpringateModelData(){
    return this.springateModelData;
  }

  public NextToResults(): void{
    this.openCalculation=false;
    this.openResults=true;
    this.calculateSpringateModel();
  }

  public getRisk(): string{
    var risk: string = '';
    if(this.finalResult.z<0.862)
      risk = 'Підприємство потенційний банкрут';
    if(this.finalResult.z>=0.862)
      risk = 'Загрози банкрутства немає';
    this.risk = risk;
    return this.risk;
  }

  public getFinalResults(): SpringateModel{
    return this.finalResult;
  }

}
