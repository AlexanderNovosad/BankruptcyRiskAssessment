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
import {CompanyFactor} from "../model/CompanyFactor";
import {DavidBelikovModel} from "../model/DavidBelikovModel";
import {SpringateModel} from "../model/SpringateModel";
import {UniversalDiscriminatoryModel} from "../model/UniversalDiscriminatoryModel";
import {DavidBelikovModelData} from "../model/DavidBelikovModelData";
import {SpringateModelData} from "../model/SpringateModelData";
import {UniversalDiscriminatoryModelData} from "../model/UniversalDiscriminatoryModelData";

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
    return this.httpClient.post<LissModel>(`/api/bankruptcy/lissModel?companyId=${companyId}`, lissModelData).toPromise();
  }

  public calculateDavidBelikovModel(companyId: number, davidBelikovModelData: DavidBelikovModelData): Promise<DavidBelikovModel>{
    return this.httpClient.post<LissModel>(`/api/bankruptcy/davidBelikovModel?companyId=${companyId}`, davidBelikovModelData).toPromise();
  }

  public calculateSpringateModel(companyId: number, springateModelData: SpringateModelData): Promise<SpringateModel>{
    return this.httpClient.post<SpringateModel>(`/api/bankruptcy/springateModel?companyId=${companyId}`, springateModelData).toPromise();
  }

  public calculateUniversalDiscriminatoryModel(companyId: number, universalDiscriminatoryModelData: UniversalDiscriminatoryModelData): Promise<UniversalDiscriminatoryModel>{
    return this.httpClient.post<UniversalDiscriminatoryModel>(`/api/bankruptcy/universalDiscriminatoryModel?companyId=${companyId}`, universalDiscriminatoryModelData).toPromise();
  }

  public getNedosekinModelIndicatorsForCompany(companyId: number){
    return this.httpClient.get<CompanyFactor[]>(`/api/bankruptcy/nedosekinModelIndicators?companyId=${companyId}`);
  }

  public getLissModelIndicatorsForCompany(companyId: number){
    return this.httpClient.get<LissModel[]>(`/api/bankruptcy/lissModelIndicators?companyId=${companyId}`);
  }

  public getDavidBelikovModelIndicatorsForCompany(companyId: number){
    return this.httpClient.get<DavidBelikovModel[]>(`/api/bankruptcy/davidBelikovModelIndicators?companyId=${companyId}`);
  }

  public getMultiFactorModelOfAltmanIndicatorsForCompany(companyId: number){
    return this.httpClient.get<MultiFactorModelOfAltman[]>(`/api/bankruptcy/multiFactorModelOfAltmanIndicators?companyId=${companyId}`);
  }

  public getSpringateModelIndicatorsForCompany(companyId: number){
    return this.httpClient.get<SpringateModel[]>(`/api/bankruptcy/springateModelIndicators?companyId=${companyId}`);
  }

  public getUniversalDiscriminatoryModelIndicatorsForCompany(companyId: number){
    return this.httpClient.get<UniversalDiscriminatoryModel[]>(`/api/bankruptcy/universalDiscriminatoryModelIndicators?companyId=${companyId}`);
  }



}
