import { Component, OnInit } from '@angular/core';
import {User} from "../../../model/User";
import {UserService} from "../../../service/user.service";
import {Company} from "../../../model/Company";
import {ExpertAccess} from "../../../model/ExpertAccess";
import {CompanyService} from "../../../service/company.service";

@Component({
  selector: 'app-profile-company',
  templateUrl: './profile-company.component.html',
  styleUrls: ['./profile-company.component.css']
})
export class ProfileCompanyComponent implements OnInit {

  companyList: Company[]=[];
  expertAccessList: ExpertAccess[]=[];
  expertsList: User[];
  selectedCompany = 0;
  selectedExpert = 0;
  mainBlockOpen: boolean;
  constructor(private companyService: CompanyService, private userService: UserService) {
  }

  ngOnInit() {
    this.companyService.getCompanies(this.getCurrentUser().userId).then(expertAccessList=>this.expertAccessList=expertAccessList);
    this.userService.getExperts().subscribe((experts:User[]) => this.expertsList = experts, error => {console.log(error);});
    this.mainBlockOpen = true;
  }

  public getCompanyList(): Company[] {
    this.companyList = [];
    this.expertAccessList.forEach(expertAccess=>this.companyList.push(expertAccess.company));
    return this.companyList;
  }

  public getOwnCompanyList(): Company[] {
    var ownCompanyList = [];
    for(var i=0;i<this.companyList.length;i++){
      if(this.companyList[i].headOfCompany==this.getCurrentUser()){
        ownCompanyList.push(this.companyList[i]);
      }
    }
    return ownCompanyList;
  }

  public getCurrentUser(): User{
    return this.userService.getCurrentUser();
  }

  public getExpertList(): User[]{
    var experts: User[]=[];
    experts = this.expertsList;
    return experts;
  }

  public setExpertForCompany(){
    let expert: User;
    let company: Company;
    this.userService.getUserById(this.selectedExpert).then(user=>expert=user);
    this.companyService.getCompanyById(this.selectedCompany).then(company=>company=company);
    this.userService.setExpertForCompany({expertAccessId: 0,
    expert: expert,
    company: company});
  }

  public checkMainBlock(){
    return this.mainBlockOpen;
  }

  public colseMainBlock(){
    this.mainBlockOpen = false;
    return this.mainBlockOpen;
  }

}
