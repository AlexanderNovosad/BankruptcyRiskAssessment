import { Component, OnInit } from '@angular/core';
import {CompanyService} from "../../../service/company.service";
import {Company} from "../../../model/Company";
import {UserService} from "../../../service/user.service";
import {ExpertAccess} from "../../../model/ExpertAccess";
import {BankruptcyService} from "../../../service/bankruptcy.service";
import {UniversalDiscriminatoryModel} from "../../../model/UniversalDiscriminatoryModel";
import {UniversalDiscriminatoryModelData} from "../../../model/UniversalDiscriminatoryModelData";

@Component({
  selector: 'app-universal-discriminatory-model',
  templateUrl: './universal-discriminatory-model.component.html',
  styleUrls: ['./universal-discriminatory-model.component.css']
})
export class  UniversalDiscriminatoryModelComponent implements OnInit {

  constructor(private companyService: CompanyService, private userService: UserService, private bancruptcyService: BankruptcyService) { }
  companyList: Company[]=[];
  expertAccessList: ExpertAccess[]=[];
  selectedCompany = 0;
  company: Company = null;
  openResults: boolean = false;
  openCalculation: boolean = false;
  finalResult:  UniversalDiscriminatoryModel;
  universalDiscriminatoryModelData: UniversalDiscriminatoryModelData;
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
    this.universalDiscriminatoryModelData = new UniversalDiscriminatoryModelData();
    this.openResults=false;
    this.openCalculation = true;
    return this.company;
  }

  public calculateUniversalDiscriminatoryModel(){
    this.bancruptcyService.calculateUniversalDiscriminatoryModel(this.company.companyId, this.universalDiscriminatoryModelData).then(results=>this.finalResult=results);
    return this.finalResult;
  }

  public getUniversalDiscriminatoryModelData(){
    return this.universalDiscriminatoryModelData;
  }

  public NextToResults(): void{
    this.openCalculation=false;
    this.openResults=true;
    this.calculateUniversalDiscriminatoryModel();
  }

  public getRisk(): string{
    var risk: string = '';
    if(this.finalResult.z<0)
      risk = 'Підприємство є напівбанкрутом';
    if(this.finalResult.z>0 && this.finalResult.z<1)
      risk = 'Підприємству загрожує банкрутство, якщо воно не здійснить санаційних заходів';
    if(this.finalResult.z>1 && this.finalResult.z<2)
      risk = 'Фінансова рівновага порушена, але за умови переходу підприємства на антикризове управління банкрутство йому не загрожує';
    if(this.finalResult.z>2)
      risk = 'Підприємство вважається фінансово стійким і йому не загрожує банкрутство';
    this.risk = risk;
    return this.risk;
  }

  public getFinalResults(): UniversalDiscriminatoryModel{
    return this.finalResult;
  }

}
