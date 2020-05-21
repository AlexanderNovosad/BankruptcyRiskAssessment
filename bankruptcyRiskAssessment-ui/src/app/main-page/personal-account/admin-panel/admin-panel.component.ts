import { Component, OnInit } from '@angular/core';
import {UserService} from '../../../service/user.service';
import {User} from '../../../model/User';
import {Router} from '@angular/router';
import {Role, roleList} from '../../../model/Role';
import {CompanyService} from "../../../service/company.service";
import {Company} from "../../../model/Company";

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {

  currentUser: User;
  companyList: Company[];
  expertsList: User[];
  public searchUserBy = '';
  userList: User[];

  constructor(private companyService: CompanyService, private userService: UserService) {
    this.currentUser = userService.getCurrentUser();
  }

  ngOnInit() {
    this.userService.getUsers().then(users => this.userList = users);
    this.companyService.getCompaniesForConfirmation().subscribe(data => this.companyList = data);
    this.userService.getExperts().subscribe((experts:User[]) => this.expertsList = experts, error => {console.log(error);});
  }

  public getCompanyListForConfirmation(): Company[] {
    if(this.companyList!=null){
      if(this.companyList.length == 0)
        this.companyList=null;
    }
    return this.companyList;
  }

  public getUserList(): User[]{
    var notExpertList: User[] = [];
    if(this.userList!=null){
      for(var i=0; i<this.userList.length; i++){
        if(this.userList[i].role.roleId!=3)
          notExpertList.push(this.userList[i]);
      }
    }
    return notExpertList;
  }

  public getExperts(): User[]{
    return this.expertsList;
  }

  public confirmCompany(companyId: number){
    return this.companyService.confirmCompany(companyId).subscribe(data => console.log(data));
  }

  public notConfirmCompany(companyId: number){
    return this.companyService.notConfirmCompany(companyId).subscribe(data => console.log(data));
  }

  public excludeExpert(userId: number){
    return this.userService.excludeExpert(userId).subscribe(data => console.log(data));
  }

  public putUserIntoExpert(userId: number){
    console.log("work");
    return this.userService.putUserIntoExpert(userId).subscribe(data => console.log(data));
  }

}
