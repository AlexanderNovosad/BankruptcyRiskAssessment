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
  }
  //В доработке

  public getOwnersCompanies(): Company[] {
    var ownersCompanies = [];
    this.companyService.getOwnersCompanies(this.currentUser.userId).subscribe(data => (ownersCompanies=data));
    return ownersCompanies;
  }

  public getNedosekinModelIndicatorsForCompany(company: Company): CompanyFactor[]{
    var nedosekinModelIndicators = [];
    this.bankruptcyService.getNedosekinModelIndicatorsForCompany(company.companyId).subscribe(data => nedosekinModelIndicators=data);
    return nedosekinModelIndicators;
  }

  public getLissModelIndicatorsForCompany(company: Company): LissModel[]{
    var lissModelIndicators = [];
    this.bankruptcyService.getLissModelIndicatorsForCompany(company.companyId).subscribe(data => lissModelIndicators=data);
    return lissModelIndicators;
  }

  public getDavidBelikovModelIndicatorsForCompany(company: Company): DavidBelikovModel[]{
    var davidBelikovModelIndicators = [];
    this.bankruptcyService.getDavidBelikovModelIndicatorsForCompany(company.companyId).subscribe(data => davidBelikovModelIndicators=data);
    return davidBelikovModelIndicators;
  }

  public getMultiFactorModelOfAltmanIndicatorsForCompany(company: Company): MultiFactorModelOfAltman[]{
    var multiFactorModelOfAltmanIndicators = [];
    this.bankruptcyService.getMultiFactorModelOfAltmanIndicatorsForCompany(company.companyId).subscribe(data => multiFactorModelOfAltmanIndicators=data);
    return multiFactorModelOfAltmanIndicators;
  }

  public getSpringateModelIndicatorsForCompany(company: Company): SpringateModel[]{
    var springateModelIndicators = [];
    this.bankruptcyService.getSpringateModelIndicatorsForCompany(company.companyId).subscribe(data => springateModelIndicators=data);
    return springateModelIndicators;
  }

  public getUniversalDiscriminatoryModelIndicatorsForCompany(company: Company): UniversalDiscriminatoryModel[]{
    var universalDiscriminatoryModelIndicators = [];
    this.bankruptcyService.getUniversalDiscriminatoryModelIndicatorsForCompany(company.companyId).subscribe(data => universalDiscriminatoryModelIndicators=data);
    return universalDiscriminatoryModelIndicators;
  }

}
