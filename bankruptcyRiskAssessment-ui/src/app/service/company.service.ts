import { Injectable } from '@angular/core';
import {User} from '../model/User';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { map } from 'rxjs/operators';
import {Role} from "../model/Role";
import {Company} from "../model/Company";
import {ExpertAccess} from "../model/ExpertAccess";
import {Router} from '@angular/router';

@Injectable()
export class CompanyService {

  constructor(private _router: Router, private httpClient: HttpClient) {}

  public getCompanies(userId: number): Promise<ExpertAccess[]> {
    return this.httpClient.get<ExpertAccess[]>(`/api/companies/company/expert?userId=${userId}`).toPromise();
  }

  public getAllCompanies(): Promise<Company[]> {
    return this.httpClient.get<Company[]>(`/api/companies/`).toPromise();
  }

  public getCompanyById(companyId: number): Promise<Company>{
    return this.httpClient.get<Company>(`/api/companies/company?companyId=${companyId}`).toPromise();
  }

  public createNewCompany(newCompany: Company) {
    return this.httpClient.post<Company>('/api/registration', newCompany)
      .subscribe(
        res => {
          this._router.navigateByUrl('');
        },
        err => {
          console.log('Error occured');
        }
      );
  }

}
