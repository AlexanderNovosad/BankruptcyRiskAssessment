import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Factor} from "../model/Factor";
import {Indicator} from "../model/Indicator";
import {QuantitativeIndicator} from "../model/QuantitativeIndicator";

@Injectable()
export class BankruptcyService{
  constructor(private httpClient: HttpClient) {}

  public getFactors(): Promise<Factor[]>{
    return this.httpClient.get<Factor[]>(`/api/bankruptcy/factors`).toPromise();
  }

  public createQualitativeIndicators(factors: Factor[]): Promise<Indicator[]>{
    console.log(factors);
    return this.httpClient.post<Indicator[]>(`/api/bankruptcy/indicators/QualitativeIndicators`,factors).toPromise();
  }

  public createQuantitativeIndicators(factors: Factor[]): Promise<QuantitativeIndicator[]>{
    console.log(factors);
    return this.httpClient.post<QuantitativeIndicator[]>(`/api/bankruptcy/indicators/QuantitativeIndicators`,factors).toPromise();
  }

}
