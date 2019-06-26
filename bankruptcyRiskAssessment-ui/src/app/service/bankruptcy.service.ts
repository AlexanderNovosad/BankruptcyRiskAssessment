import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Factor} from "../model/Factor";
import {Indicator} from "../model/Indicator";
import {QuantitativeIndicator} from "../model/QuantitativeIndicator";
import {PreQuantitativeIndicator} from "../model/PreQuantitativeIndicator";
import {LinguisticAssessment} from "../model/LinguisticAssessment";
import {MultiFactorModelOfAltman} from "../model/MultiFactorModelOfAltman";
import {MultiFactorModelOfAltmanData} from "../model/MultiFactorModelOfAltmanData";
import {LissModel} from "../model/LissModel";
import {LissModelData} from "../model/LissModelData";

@Injectable()
export class BankruptcyService{
  constructor(private httpClient: HttpClient) {}

  public getFactors(): Promise<Factor[]>{
    return this.httpClient.get<Factor[]>(`/api/bankruptcy/factors`).toPromise();
  }

  public getQualitativeIndicators(): Promise<Indicator[]>{
    return this.httpClient.get<Indicator[]>(`/api/bankruptcy/indicators/QualitativeIndicators`).toPromise();
  }

  public getQuantitativeIndicators(): Promise<QuantitativeIndicator[]>{
    return this.httpClient.get<QuantitativeIndicator[]>(`/api/bankruptcy/indicators/QuantitativeIndicators`).toPromise();
  }

  public getPreQuantitativeIndicators(quantitativeIndicators: QuantitativeIndicator[]): Promise<PreQuantitativeIndicator[]>{
    return this.httpClient.post<PreQuantitativeIndicator[]>(`/api/bankruptcy/indicators/QuantitativeIndicators/PreQuantitativeIndicators`, quantitativeIndicators).toPromise();
  }

  public calculateAmountOfQuantitativeIndicators(quantitativeIndicatorsList: QuantitativeIndicator[], preQuantitativeIndicatorsList: PreQuantitativeIndicator[]): Promise<QuantitativeIndicator[]>{
    let inData = {quantitativeIndicators: quantitativeIndicatorsList, preQuantitativeIndicators: preQuantitativeIndicatorsList};
    return this.httpClient.post<QuantitativeIndicator[]>(`/api/bankruptcy/indicators/QuantitativeIndicators`, inData).toPromise();
  }

  public setTheAssessments(indicators: Indicator[], assessments: LinguisticAssessment[]): Promise<Indicator[]>{
    let inData = {IndicatorList: indicators, assessmentList: assessments};
    return this.httpClient.post<Indicator[]>(`/api/bankruptcy/indicatorsAssessments`, inData).toPromise();
  }

  public calculateBankruptcyPoints(companyId: number, indicatorList: [Indicator[]], dependenceList: [String[]], factorsDependenceList: String[]): Promise<Factor[]>{
    let inData = {indicators: indicatorList, dependencies: dependenceList, factorsDependencies: factorsDependenceList};
    console.log(inData);
    return this.httpClient.post<Factor[]>(`/api/bankruptcy/nedosekinModel?companyId=${companyId}`, inData).toPromise();
  }

  public calculateMultiFactorModelOfAltman(companyId: number, multiFactorModelOfAltmanData: MultiFactorModelOfAltmanData): Promise<MultiFactorModelOfAltman>{
    return this.httpClient.post<MultiFactorModelOfAltman>(`/api/bankruptcy/multiFactorModelOfAltman?companyId=${companyId}`, multiFactorModelOfAltmanData).toPromise();
  }

  public calculateLissModel(companyId: number, lissModelData: LissModelData): Promise<LissModel>{
    return this.httpClient.post<LissModel>(`/api/bankruptcy/multiFactorModelOfAltman?companyId=${companyId}`, lissModelData).toPromise();
  }



}
