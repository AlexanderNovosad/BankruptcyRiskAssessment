import { Component, OnInit } from '@angular/core';
import {User} from "../../../model/User";
import {Company} from "../../../model/Company";
import {CompanyFactor} from "../../../model/CompanyFactor";
import {LissModel} from "../../../model/LissModel";
import {DavidBelikovModel} from "../../../model/DavidBelikovModel";
import {MultiFactorModelOfAltman} from "../../../model/MultiFactorModelOfAltman";
import {SpringateModel} from "../../../model/SpringateModel";
import {UniversalDiscriminatoryModel} from "../../../model/UniversalDiscriminatoryModel";
import {BankruptcyService} from "../../../service/bankruptcy.service";
import {CompanyService} from "../../../service/company.service";
import {UserService} from "../../../service/user.service";
import {ExpertAccess} from "../../../model/ExpertAccess";
import {MessageService} from "../../../service/message.service";

@Component({
  selector: 'app-recommendations',
  templateUrl: './recommendations.component.html',
  styleUrls: ['./recommendations.component.css']
})
export class RecommendationsComponent implements OnInit {

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
  constructor(private bankruptcyService: BankruptcyService, private companyService: CompanyService, private userService: UserService, private messageService: MessageService) {
    this.currentUser = userService.getCurrentUser();
  }

  ngOnInit() {
    this.companyService.getExpertCompanies(this.currentUser.userId).then(expertAccessList=>this.expertAccessList=expertAccessList);
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

  public sendRecommendation(problemDescription: string, recommendationDescription: string){
    if(this.selectedCompany == 0 && this.expertCompanies != []){
      this.selectedCompany = this.getExpertCompanies()[0].companyId;
    }
    var company: Company = this.getExpertCompanies().find(this.findCompany);
    return this.bankruptcyService.sendRecommendation({
      recommendationId: 0,
    expert: this.currentUser,
      company: company,
      problemDescription: problemDescription,
      recommendationDescription: recommendationDescription,
      date: Date.now()});
  }

}
