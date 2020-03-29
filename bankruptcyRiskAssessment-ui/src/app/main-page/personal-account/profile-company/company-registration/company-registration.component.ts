 import { Component, OnInit } from '@angular/core';
 import {roleList} from "../../../../model/Role";
 import {CompanyService} from "../../../../service/company.service";
 import {User} from "../../../../model/User";
 import {UserService} from "../../../../service/user.service";

 @Component({
   selector: 'app-company-registration',
   templateUrl: './company-registration.component.html',
   styleUrls: ['./company-registration.component.css']
 })
 export class CompanyRegistrationComponent implements OnInit {

   currentUser: User;

   constructor(private userService: UserService, private companyService: CompanyService) { }

   ngOnInit() {
     this.currentUser = this.userService.getCurrentUser();
   }

    public registration(kindOfCompany, ipn, companyName, quadDescription, edrpou, address, phone) {
        this.companyService.createNewCompany({
          companyId: 0,
          kindOfCompany: kindOfCompany,
          headOfCompany: this.currentUser,
          ipn: ipn,
          companyName: companyName,
          quadDescription: quadDescription,
          edrpou: edrpou,
          address: address,
          phone: phone,
          confirmation: false,
        });
      }

 }
