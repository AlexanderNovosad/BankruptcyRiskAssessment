package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.unit.Factor;
import com.api.BankruptcyRiskAssessment.entity.unit.Indicator;
import com.api.BankruptcyRiskAssessment.entity.unit.LinguisticAssessment;
import com.api.BankruptcyRiskAssessment.entity.unit.QuantitativeIndicator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankruptcyService implements IBankruptcyService {

    @Override
    public ArrayList<Indicator> setThePointsForIndicators(ArrayList<Indicator> indicators, List<LinguisticAssessment> assessments){
        assessments.forEach(assessment -> indicators.forEach(indicator -> indicator.setAssessment(assessment)));
        return indicators;
    }

    @Override
    public ArrayList<Indicator> createQualitativeIndicators(List<Factor> factors){
        ArrayList<Indicator> indicators = new ArrayList<>();

        Indicator dimensionsAndProductionCapacity = new Indicator("Розміри та потужність виробництва", factors.get(0));
        indicators.add(dimensionsAndProductionCapacity);
        Indicator typeAndAgeOfEquipment = new Indicator("Тип і вік обладнання", factors.get(0));
        indicators.add(typeAndAgeOfEquipment);
        Indicator sourcesOfSupply = new Indicator("Джерела постачання", factors.get(0));
        indicators.add(sourcesOfSupply);
        Indicator rationingWorks = new Indicator("Нормування робіт", factors.get(0));
        indicators.add(rationingWorks);
        Indicator availabilityOfNewTechnologiesAndEquipment = new Indicator("Доступність нових технологій та обладнання на ринку", factors.get(0));
        indicators.add(availabilityOfNewTechnologiesAndEquipment);
        Indicator technologicalStructureOfInvestments = new Indicator("Технологічна структура капіталовкладень", factors.get(0));
        indicators.add(technologicalStructureOfInvestments);

        Indicator theImageOfTheManager = new Indicator("Імідж керівника", factors.get(1));
        indicators.add(theImageOfTheManager);
        Indicator numberOfLevelsOfManagerialHierarchy = new Indicator("Кількість рівнів управлінської ієрархії", factors.get(1));
        indicators.add(numberOfLevelsOfManagerialHierarchy);
        Indicator corporateCulture = new Indicator("Корпоративна культура", factors.get(1));
        indicators.add(corporateCulture);
        Indicator relationshipsWithCompetitors = new Indicator("Стосунки з конкурентами", factors.get(1));
        indicators.add(relationshipsWithCompetitors);
        Indicator partnersOfTheEnterprise = new Indicator("Партнери підприємства", factors.get(1));
        indicators.add(partnersOfTheEnterprise);
        Indicator contractors = new Indicator("Підрядники", factors.get(1));
        indicators.add(contractors);
        Indicator mediators = new Indicator("Посередники", factors.get(1));
        indicators.add(mediators);
        Indicator investors = new Indicator("Інвестори", factors.get(1));
        indicators.add(investors);
        Indicator theStateAndLocalGovernments = new Indicator("Органи державної та місцевої влади", factors.get(1));
        indicators.add(theStateAndLocalGovernments);
        Indicator regulatoryAuthorities = new Indicator("Контролюючі органи", factors.get(1));
        indicators.add(regulatoryAuthorities);

        Indicator sourcesOfCashReceipts = new Indicator("Джерела грошових надходжень", factors.get(2));
        indicators.add(sourcesOfCashReceipts);
        Indicator pricingPolicy = new Indicator("Цінова політика", factors.get(2));
        indicators.add(pricingPolicy);
        Indicator reservesToIncreaseProfits = new Indicator("Резерви збільшення прибутку", factors.get(2));
        indicators.add(reservesToIncreaseProfits);
        Indicator newOpportunitiesForReinvestingProfits = new Indicator("Нові можливості реінвестування прибутку", factors.get(2));
        indicators.add(newOpportunitiesForReinvestingProfits);
        Indicator taxSystem = new Indicator("Система оподаткування", factors.get(2));
        indicators.add(taxSystem);
        Indicator knowledgeOfBusiness = new Indicator("Знання бізнесу", factors.get(2));
        indicators.add(knowledgeOfBusiness);
        Indicator strategicFinancialGoals = new Indicator("Стратегічні фінансові цілі", factors.get(2));
        indicators.add(strategicFinancialGoals);
        Indicator levelOfCompetitionInTheIndustry = new Indicator("Рівень конкуренції в галузі", factors.get(2));
        indicators.add(levelOfCompetitionInTheIndustry);
        Indicator theLevelOfDemandForProducts = new Indicator("Рівень попиту на продукцію", factors.get(2));
        indicators.add(theLevelOfDemandForProducts);
        Indicator mechanismsAndProceduresForCreatingNewBusiness = new Indicator("Механізми і процедури створення нового бізнесу", factors.get(2));
        indicators.add(mechanismsAndProceduresForCreatingNewBusiness);

        Indicator theProcedureForRecruitment = new Indicator("Процедура підбору кадрів", factors.get(3));
        indicators.add(theProcedureForRecruitment);
        Indicator professionalQualification = new Indicator("Професійна кваліфікація", factors.get(3));
        indicators.add(professionalQualification);
        Indicator theSystemOfStimulation = new Indicator("Система стимулювання", factors.get(3));
        indicators.add(theSystemOfStimulation);

        Indicator theEffectivenessOfAdvertising = new Indicator("Ефективність використання реклами", factors.get(4));
        indicators.add(theEffectivenessOfAdvertising);
        Indicator qualityOfMarketingResearch = new Indicator("Якість маркетингових досліджень", factors.get(4));
        indicators.add(qualityOfMarketingResearch);
        Indicator qualityOfCustomerService = new Indicator("Якість обслуговування клієнтів", factors.get(4));
        indicators.add(qualityOfCustomerService);
        Indicator activitiesOfCompetitorsAndMassMedia = new Indicator("Діяльність конкурентів, ЗМІ", factors.get(4));
        indicators.add(activitiesOfCompetitorsAndMassMedia);
        Indicator organizationOfSalesAndService = new Indicator("Організація продажів та сервісу (система збуту)", factors.get(4));
        indicators.add(organizationOfSalesAndService);
        Indicator PRActivityOfTheEnterpriseAndItsCompetitors = new Indicator("PR-діяльність підприємства та його конкурентів", factors.get(4));
        indicators.add(PRActivityOfTheEnterpriseAndItsCompetitors);
        Indicator theDegreeOfTheIndustrysLifeCycle = new Indicator("Ступінь життєвого циклу галузі", factors.get(4));
        indicators.add(theDegreeOfTheIndustrysLifeCycle);
        Indicator attractionOfMarketingAgencies = new Indicator("Залучення маркетингових агенцій", factors.get(4));
        indicators.add(attractionOfMarketingAgencies);

        Indicator developmentOfInnovativeProducts = new Indicator("Розробка інноваційної  продукції", factors.get(5));
        indicators.add(developmentOfInnovativeProducts);
        Indicator matchingOfSpecificInnovations = new Indicator("Відповідності конкретного інноваційного проекту (конкретної інновації) інтересам різних категорій працівників і власників підприємства", factors.get(5));
        indicators.add(matchingOfSpecificInnovations);
        Indicator attractingOutsourcingCompanies = new Indicator("Залучення аутсорсингових компаній", factors.get(5));
        indicators.add(attractingOutsourcingCompanies);

        return indicators;
    }

    @Override
    public ArrayList<QuantitativeIndicator> createQuantitativeIndicators(List<Factor> factors){
        ArrayList<QuantitativeIndicator> indicators = new ArrayList<>();

        QuantitativeIndicator rateOfIncreaseInIndustrialProduction = new QuantitativeIndicator("Темп приросту (зниження) промислового обсягу виробництва (%)", factors.get(0));
        indicators.add(rateOfIncreaseInIndustrialProduction);
        QuantitativeIndicator rateOfIncreaseInProductionCosts = new QuantitativeIndicator("Темп приросту (зниження) собівартості продукції (%)", factors.get(0));
        indicators.add(rateOfIncreaseInProductionCosts);
        QuantitativeIndicator specificGravityOfTheCostOfProductionInTheTotalCost = new QuantitativeIndicator("Питома вага собівартості продукції у загальній сумі витрат (%)", factors.get(0));
        indicators.add(specificGravityOfTheCostOfProductionInTheTotalCost);
        QuantitativeIndicator costsFor1UAHOfSoldProducts = new QuantitativeIndicator("Ватрати на 1 грн. реалізованої продукції", factors.get(0));
        indicators.add(costsFor1UAHOfSoldProducts);
        QuantitativeIndicator laborProductivity = new QuantitativeIndicator("Продуктивність праці (тис.грн./чол)", factors.get(0));
        indicators.add(laborProductivity);

        QuantitativeIndicator rateOfIncomeGrowth = new QuantitativeIndicator("Темп приросту (зниження) доходів (%)", factors.get(1));
        indicators.add(rateOfIncomeGrowth);
        QuantitativeIndicator rateOfGrowthOfExpenses = new QuantitativeIndicator("Темп приросту (зниження) витрат (%)", factors.get(1));
        indicators.add(rateOfGrowthOfExpenses);
        QuantitativeIndicator theRatioOfReturnOnSalesToTheAmountOfAssets = new QuantitativeIndicator("Відношення прибутку від реалізації до суми активів", factors.get(1));
        indicators.add(theRatioOfReturnOnSalesToTheAmountOfAssets);
        QuantitativeIndicator turnoverOfAccountsReceivable = new QuantitativeIndicator("Оборотність дебіторської заборгованості (обор)", factors.get(1));
        indicators.add(turnoverOfAccountsReceivable);
        QuantitativeIndicator repaymentPeriodOfAccountsReceivable = new QuantitativeIndicator("Період погашення дебіторської заборгованості (дні)", factors.get(1));
        indicators.add(repaymentPeriodOfAccountsReceivable);
        QuantitativeIndicator turnoverOfAccountsPayable = new QuantitativeIndicator("Оборотність кредиторської заборгованості (обор)", factors.get(1));
        indicators.add(turnoverOfAccountsPayable);
        QuantitativeIndicator repaymentPeriodOfAccountsPayable = new QuantitativeIndicator("Період погашення кредиторської заборгованості (дні)", factors.get(1));
        indicators.add(repaymentPeriodOfAccountsPayable);
        QuantitativeIndicator durationOfTheOperatingCycle = new QuantitativeIndicator("Тривалість операційного циклу, днів", factors.get(1));
        indicators.add(durationOfTheOperatingCycle);
        QuantitativeIndicator durationOfTheFinancialCycle = new QuantitativeIndicator("Тривалість фінансового циклу, днів", factors.get(1));
        indicators.add(durationOfTheFinancialCycle);
        QuantitativeIndicator theRatioOfRapidlyRealizedAssetsToTheAmountOfAssets = new QuantitativeIndicator("Відношення швидко реалізованих активів до суми активів", factors.get(1));
        indicators.add(theRatioOfRapidlyRealizedAssetsToTheAmountOfAssets);
        QuantitativeIndicator theRatioOfWorkingCapitalToSalesProceeds = new QuantitativeIndicator("Відношення оборотного капіталу до виручки від реалізації", factors.get(1));
        indicators.add(theRatioOfWorkingCapitalToSalesProceeds);

        QuantitativeIndicator f31 = new QuantitativeIndicator("Рентабельність активів (%)", factors.get(2));
        indicators.add(f31);
        QuantitativeIndicator f32 = new QuantitativeIndicator("Рентабельність власного капіталу(%)", factors.get(2));
        indicators.add(f32);
        QuantitativeIndicator f33 = new QuantitativeIndicator("Рентабельність продажу (%)", factors.get(2));
        indicators.add(f33);
        QuantitativeIndicator f34 = new QuantitativeIndicator("Рентабельність чистих актвів (%)", factors.get(2));
        indicators.add(f34);
        QuantitativeIndicator f35 = new QuantitativeIndicator("Рентабельність власного капіталу (%)", factors.get(2));
        indicators.add(f35);
        QuantitativeIndicator f36 = new QuantitativeIndicator("Рентабельність реалізованих товарів, робіт послуг (%)", factors.get(2));
        indicators.add(f36);
        QuantitativeIndicator f37 = new QuantitativeIndicator("Рентабельність оборотних активів (%)", factors.get(2));
        indicators.add(f37);
        QuantitativeIndicator f38 = new QuantitativeIndicator("Відношення виручки від реалізації до швидко реалізованих активів", factors.get(2));
        indicators.add(f38);
        QuantitativeIndicator f39 = new QuantitativeIndicator("Відношення прибутку до сплати податків до суми активів (%)", factors.get(2));
        indicators.add(f39);
        QuantitativeIndicator f310 = new QuantitativeIndicator("Власний оборотний капітал", factors.get(2));
        indicators.add(f310);
        QuantitativeIndicator f311 = new QuantitativeIndicator("Відношення власного оборотного капіталу до суми активів", factors.get(2));
        indicators.add(f311);
        QuantitativeIndicator f312 = new QuantitativeIndicator("Відношення зобовязань до власного капіталу", factors.get(2));
        indicators.add(f312);
        QuantitativeIndicator f313 = new QuantitativeIndicator("Відношення власного капіталу до залученого", factors.get(2));
        indicators.add(f313);
        QuantitativeIndicator f314 = new QuantitativeIndicator("Оборотність активів", factors.get(2));
        indicators.add(f314);
        QuantitativeIndicator f315 = new QuantitativeIndicator("Частка мобільних активів у загальній величині майна підприємства", factors.get(2));
        indicators.add(f315);
        QuantitativeIndicator f316 = new QuantitativeIndicator("Відношення оборотного капіталу до суми активів", factors.get(2));
        indicators.add(f316);
        QuantitativeIndicator f317 = new QuantitativeIndicator("Коефіцієнт заборгованості", factors.get(2));
        indicators.add(f317);
        QuantitativeIndicator f318 = new QuantitativeIndicator("Відношення основного капіталу до суми чистих активів", factors.get(2));
        indicators.add(f318);
        QuantitativeIndicator f319 = new QuantitativeIndicator("Показники абсолютної платоспроможності", factors.get(2));
        indicators.add(f319);
        QuantitativeIndicator f320 = new QuantitativeIndicator("Показники проміжної платоспроможності", factors.get(2));
        indicators.add(f320);
        QuantitativeIndicator f321 = new QuantitativeIndicator("Показники загальної платоспроможності", factors.get(2));
        indicators.add(f321);
        QuantitativeIndicator f322 = new QuantitativeIndicator("Коефіцієнт фінансової незалежності (автономії)", factors.get(2));
        indicators.add(f322);
        QuantitativeIndicator f323 = new QuantitativeIndicator("Питома вага фінансових інвестицій в загальній сумі активів (%)", factors.get(2));
        indicators.add(f323);
        QuantitativeIndicator f324 = new QuantitativeIndicator("Прибутковість фінансових інвестицій", factors.get(2));
        indicators.add(f324);

        QuantitativeIndicator f41 = new QuantitativeIndicator("Плинність кадрів", factors.get(3));
        indicators.add(f41);
        QuantitativeIndicator f42 = new QuantitativeIndicator("Середньомісячна заробітна плата", factors.get(3));
        indicators.add(f42);
        QuantitativeIndicator f43 = new QuantitativeIndicator("Темп зростання (зниження) середньомісячної заробітної плати (%)", factors.get(3));
        indicators.add(f43);

        QuantitativeIndicator f51 = new QuantitativeIndicator("Рентабельність продажу", factors.get(4));
        indicators.add(f51);
        QuantitativeIndicator f52 = new QuantitativeIndicator("Місткість ринку", factors.get(4));
        indicators.add(f52);
        QuantitativeIndicator f53 = new QuantitativeIndicator("Оборотність товарно-матеріальних запасів", factors.get(4));
        indicators.add(f53);
        QuantitativeIndicator f54 = new QuantitativeIndicator("Період обороту товарно-матеріальних запасів", factors.get(4));
        indicators.add(f54);
        QuantitativeIndicator f55 = new QuantitativeIndicator("Маржинальний дохід", factors.get(4));
        indicators.add(f55);

        QuantitativeIndicator f61 = new QuantitativeIndicator("Частку приросту продукції за рахунок інтенсифікації виробництва", factors.get(5));
        indicators.add(f61);

        return indicators;
    }

    @Override
    public ArrayList<Factor> createFactors(){
        Factor productionFactor = new Factor("Виробничий фактор");
        Factor managementFactor = new Factor("Управлінський фактор");
        Factor financialFactor = new Factor("Фінансовий фактор");
        Factor personnelFactor = new Factor("Кадровий фактор");
        Factor marketingFactor = new Factor("Маркетинговий фактор");
        Factor innovationFactor = new Factor("Інноваційний фактор");
        ArrayList<Factor> factors = new ArrayList<>();
        factors.add(productionFactor);
        factors.add(managementFactor);
        factors.add(financialFactor);
        factors.add(personnelFactor);
        factors.add(marketingFactor);
        factors.add(innovationFactor);
        return factors;
    }

//    @Override
//    public ArrayList<QuantitativeIndicator> setThePointsQuantitativeIndicators(ArrayList<QuantitativeIndicator> indicators, List<LinguisticAssessment> assessments){
//        assessments.forEach(assessment -> indicators.forEach(indicator -> indicator.setAssessment(assessment)));
//        return indicators;
//    }

    @Override
    public Factor calculateFactorPoints(ArrayList<Indicator> factorIndicators, ArrayList<String> factorDependencies){
        int[] r = new int[factorIndicators.size()];
        r[factorIndicators.size()-1] = 1;
        for(int i = factorDependencies.size(); i>0; i--){
            if(factorDependencies.get(i) == "="){
                r[i-1] = r[i];
            }
            else {
                r[i-1] = r[i]+1;
            }
        }

        int K = 0;
        for (int i = 0; i<factorIndicators.size(); i++){
            K = K+r[i];
        }

        double[] p = new double[factorIndicators.size()];
        for (int i = 0; i<factorIndicators.size(); i++){
            p[i] = r[i]/K;
        }

        Factor factor = factorIndicators.get(1).getFactor();
        for(int i = 0; i<factorIndicators.size(); i++){
            factor.getAssessment().setA(factor.getAssessment().getA()+factorIndicators.get(i).getAssessment().getA()*p[i]);
            factor.getAssessment().setB(factor.getAssessment().getB()+factorIndicators.get(i).getAssessment().getB()*p[i]);
            factor.getAssessment().setC(factor.getAssessment().getC()+factorIndicators.get(i).getAssessment().getC()*p[i]);
            factor.getAssessment().setD(factor.getAssessment().getD()+factorIndicators.get(i).getAssessment().getD()*p[i]);
        }

        LinguisticAssessment[] linguisticAssessments = {new LinguisticAssessment("Дуже низький"), new LinguisticAssessment("Низький"), new LinguisticAssessment("Середній"), new LinguisticAssessment("Високий"), new LinguisticAssessment("Дуже високий")};
        double a = Math.min(Math.abs(factor.getAssessment().getA()-linguisticAssessments[0].getA()), Math.abs(factor.getAssessment().getA()-linguisticAssessments[1].getA()));
        double b = Math.min(Math.abs(factor.getAssessment().getB()-linguisticAssessments[0].getB()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[1].getB()));
        double c = Math.min(Math.abs(factor.getAssessment().getC()-linguisticAssessments[0].getC()), Math.abs(factor.getAssessment().getC()-linguisticAssessments[1].getC()));
        double d = Math.min(Math.abs(factor.getAssessment().getD()-linguisticAssessments[0].getD()), Math.abs(factor.getAssessment().getD()-linguisticAssessments[1].getD()));
        for(int i = 2; i<5; i++){
            a = Math.min(a, Math.abs(factor.getAssessment().getA()-linguisticAssessments[i].getA()));
            b = Math.min(b, Math.abs(factor.getAssessment().getB()-linguisticAssessments[i].getB()));
            c = Math.min(c, Math.abs(factor.getAssessment().getC()-linguisticAssessments[i].getC()));
            d = Math.min(d, Math.abs(factor.getAssessment().getD()-linguisticAssessments[i].getD()));
        }
        if(a<0.15 && a>=0 && b<0.25 && b>=0 && c<0.35 && c>0.15 && d<0.45 && d>0.25)
            factor.getAssessment().setName("Дуже низький");
        if(a<0.35 && a>=0.15 && b<0.45 && b>=0.25 && c<0.55 && c>=0.35 && d<0.65 && d>=0.45)
            factor.getAssessment().setName("Низький");
        if(a<0.55 && a>=0.35 && b<0.65 && b>=0.45 && c<0.75 && c>=0.55 && d<0.85 && d>=0.65)
            factor.getAssessment().setName("Середній");
        if(a<0.75 && a>=0.55 && b<0.85 && b>=0.65 && c<1 && c>=0.75 && d<1 && d>=0.85)
            factor.getAssessment().setName("Високий");
        if(a>=0.75 && b>=0.85 && c>=1 && d>=1)
            factor.getAssessment().setName("Дуже високий");

        double v = 0;
        if(factor.getAssessment().getName().equals("Дуже низький")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[0].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[0].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[0].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[0].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Низький")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[1].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[1].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[1].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[1].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Середній")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[2].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[2].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[2].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[2].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Високий")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[3].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[3].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[3].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[3].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Дуже високий")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[4].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[4].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[4].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[4].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        return factor;
    }

    @Override
    public Factor calculateCompanyPoints(ArrayList<Factor> factors, ArrayList<String> factorDependencies){
        int[] r = new int[factors.size()];
        r[factors.size()-1] = 1;
        for(int i = factorDependencies.size(); i>0; i--){
            if(factorDependencies.get(i) == "="){
                r[i-1] = r[i];
            }
            else {
                r[i-1] = r[i]+1;
            }
        }

        int K = 0;
        for (int i = 0; i<factors.size(); i++){
            K = K+r[i];
        }

        double[] p = new double[factors.size()];
        for (int i = 0; i<factors.size(); i++){
            p[i] = r[i]/K;
        }

        Factor factor = new Factor("Стан підприємства");
        for(int i = 0; i<factors.size(); i++){
            factor.getAssessment().setA(factor.getAssessment().getA()+factors.get(i).getAssessment().getA()*p[i]);
            factor.getAssessment().setB(factor.getAssessment().getB()+factors.get(i).getAssessment().getB()*p[i]);
            factor.getAssessment().setC(factor.getAssessment().getC()+factors.get(i).getAssessment().getC()*p[i]);
            factor.getAssessment().setD(factor.getAssessment().getD()+factors.get(i).getAssessment().getD()*p[i]);
        }

        LinguisticAssessment[] linguisticAssessments = {new LinguisticAssessment("Дуже низький"), new LinguisticAssessment("Низький"), new LinguisticAssessment("Середній"), new LinguisticAssessment("Високий"), new LinguisticAssessment("Дуже високий")};
        double a = Math.min(Math.abs(factor.getAssessment().getA()-linguisticAssessments[0].getA()), Math.abs(factor.getAssessment().getA()-linguisticAssessments[1].getA()));
        double b = Math.min(Math.abs(factor.getAssessment().getB()-linguisticAssessments[0].getB()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[1].getB()));
        double c = Math.min(Math.abs(factor.getAssessment().getC()-linguisticAssessments[0].getC()), Math.abs(factor.getAssessment().getC()-linguisticAssessments[1].getC()));
        double d = Math.min(Math.abs(factor.getAssessment().getD()-linguisticAssessments[0].getD()), Math.abs(factor.getAssessment().getD()-linguisticAssessments[1].getD()));
        for(int i = 2; i<5; i++){
            a = Math.min(a, Math.abs(factor.getAssessment().getA()-linguisticAssessments[i].getA()));
            b = Math.min(b, Math.abs(factor.getAssessment().getB()-linguisticAssessments[i].getB()));
            c = Math.min(c, Math.abs(factor.getAssessment().getC()-linguisticAssessments[i].getC()));
            d = Math.min(d, Math.abs(factor.getAssessment().getD()-linguisticAssessments[i].getD()));
        }
        if(a<0.15 && a>=0 && b<0.25 && b>=0 && c<0.35 && c>0.15 && d<0.45 && d>0.25)
            factor.getAssessment().setName("Дуже низький");
        if(a<0.35 && a>=0.15 && b<0.45 && b>=0.25 && c<0.55 && c>=0.35 && d<0.65 && d>=0.45)
            factor.getAssessment().setName("Низький");
        if(a<0.55 && a>=0.35 && b<0.65 && b>=0.45 && c<0.75 && c>=0.55 && d<0.85 && d>=0.65)
            factor.getAssessment().setName("Середній");
        if(a<0.75 && a>=0.55 && b<0.85 && b>=0.65 && c<1 && c>=0.75 && d<1 && d>=0.85)
            factor.getAssessment().setName("Високий");
        if(a>=0.75 && b>=0.85 && c>=1 && d>=1)
            factor.getAssessment().setName("Дуже високий");

        double v = 0;
        if(factor.getAssessment().getName().equals("Дуже низький")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[0].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[0].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[0].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[0].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Низький")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[1].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[1].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[1].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[1].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Середній")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[2].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[2].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[2].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[2].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Високий")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[3].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[3].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[3].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[3].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        if(factor.getAssessment().getName().equals("Дуже високий")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[4].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[4].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[4].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[4].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
        }
        return factor;
    }
}
