import { Component, OnInit } from '@angular/core';
import {User} from "../../../model/User";
import {UserService} from "../../../service/user.service";
import {CompanyService} from "../../../service/company.service";
import {BankruptcyService} from "../../../service/bankruptcy.service";
import {Company} from "../../../model/Company";
import {CompanyFactor} from "../../../model/CompanyFactor";
import {LissModel} from "../../../model/LissModel";
import {DavidBelikovModel} from "../../../model/DavidBelikovModel";
import {MultiFactorModelOfAltman} from "../../../model/MultiFactorModelOfAltman";
import {SpringateModel} from "../../../model/SpringateModel";
import {UniversalDiscriminatoryModel} from "../../../model/UniversalDiscriminatoryModel";

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  currentUser: User;
  ownersCompanies: Company[];
  nedosekinModelIndicators: CompanyFactor[];
  lissModelIndicators: LissModel[];
  davidBelikovModelIndicators: DavidBelikovModel[];
  multiFactorModelOfAltmanIndicators: MultiFactorModelOfAltman[];
  springateModelIndicators: SpringateModel[];
  universalDiscriminatoryModelIndicators: UniversalDiscriminatoryModel[];

  constructor(private bankruptcyService: BankruptcyService, private companyService: CompanyService, private userService: UserService) {
    this.currentUser = userService.getCurrentUser();
  }

  ngOnInit() {
    this.companyService.getOwnersCompanies(this.currentUser.userId).subscribe(data => (this.ownersCompanies=data));
  }

  public getOwnersCompanies(): Company[] {
    if(this.ownersCompanies!=null){
      if(this.ownersCompanies.length == 0)
        this.ownersCompanies=null;
    }
    return this.ownersCompanies;
  }

  public getStatistics(company: Company){
    this.bankruptcyService.getNedosekinModelIndicatorsForCompany(company.companyId).subscribe(data => this.nedosekinModelIndicators = data);
      this.bankruptcyService.getLissModelIndicatorsForCompany(company.companyId).subscribe(data => this.lissModelIndicators = data);
      this.bankruptcyService.getDavidBelikovModelIndicatorsForCompany(company.companyId).subscribe(data => this.davidBelikovModelIndicators = data);
      this.bankruptcyService.getMultiFactorModelOfAltmanIndicatorsForCompany(company.companyId).subscribe(data => this.multiFactorModelOfAltmanIndicators = data);
      this.bankruptcyService.getSpringateModelIndicatorsForCompany(company.companyId).subscribe(data => this.springateModelIndicators = data);
      this.bankruptcyService.getUniversalDiscriminatoryModelIndicatorsForCompany(company.companyId).subscribe(data => this.universalDiscriminatoryModelIndicators = data);
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

}
