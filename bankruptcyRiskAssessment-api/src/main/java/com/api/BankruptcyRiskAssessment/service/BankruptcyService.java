package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.*;
import com.api.BankruptcyRiskAssessment.entity.unit.*;
import com.api.BankruptcyRiskAssessment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class BankruptcyService implements IBankruptcyService {
    private final CompanyFactorRepository companyFactorRepository;
    private final LissModelRepository lissModelRepository;
    private final DavidBelikovModelRepository davidBelikovModelRepository;
    private final MultiFactorModelOfAltmanRepository multiFactorModelOfAltmanRepository;
    private final SpringateModelRepository springateModelRepository;
    private final UniversalDiscriminatoryModelRepository universalDiscriminatoryModelRepository;

    @Autowired
    public BankruptcyService(CompanyFactorRepository companyFactorRepository,
                             LissModelRepository lissModelRepository,
                             DavidBelikovModelRepository davidBelikovModelRepository,
                             MultiFactorModelOfAltmanRepository multiFactorModelOfAltmanRepository,
                             SpringateModelRepository springateModelRepository,
                             UniversalDiscriminatoryModelRepository universalDiscriminatoryModelRepository){
        this.companyFactorRepository = companyFactorRepository;
        this.lissModelRepository = lissModelRepository;
        this.davidBelikovModelRepository = davidBelikovModelRepository;
        this.multiFactorModelOfAltmanRepository = multiFactorModelOfAltmanRepository;
        this.springateModelRepository = springateModelRepository;
        this.universalDiscriminatoryModelRepository = universalDiscriminatoryModelRepository;
    }

    private static final List<Factor> factors = new ArrayList<>();
    private static final List<QuantitativeIndicator> quantitativeIndicators = new ArrayList<>();
    private static final List<Indicator> indicators = new ArrayList<>();
    private static final List<PreQuantitativeIndicator> preQuantitativeIndicators = new ArrayList<>();

    public static void initFactorsAndIndicators(){
        createFactors();
        createQualitativeIndicators();
        createQuantitativeIndicators();
        createPreQuantitativeIndicators();
    }

    @Override
    public List<Indicator> setThePointsForIndicators(InDataForSetTheAssessments inDataForSetTheAssessments){
        List<Indicator> indicatorsList = inDataForSetTheAssessments.getIndicators();
        List<LinguisticAssessment> assessments = inDataForSetTheAssessments.getAssessments();
        if(indicatorsList.isEmpty() || assessments.isEmpty()){
            throw new EntityNotFoundException("Requested data does not exist or not full");
        }
        assessments.forEach(assessment -> indicatorsList.forEach(indicator -> indicator.setAssessment(assessment)));
        return indicatorsList;
    }

    @Override
    public List<Indicator> getQualitativeIndicators(){
        List<Indicator> privateIndicators = new ArrayList<>();
        Collections.copy(privateIndicators,indicators);
        if (privateIndicators.isEmpty()) {
            throw new EntityNotFoundException("Qualitative indicators does not exist");
        }
        return privateIndicators;
    }

    private static void createQualitativeIndicators(){
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
    }

    @Override
    public List<QuantitativeIndicator> getQuantitativeIndicators(){
        List<QuantitativeIndicator> privateQuantitativeIndicators = new ArrayList<>();
        Collections.copy(privateQuantitativeIndicators, quantitativeIndicators);
        if (privateQuantitativeIndicators.isEmpty()) {
            throw new EntityNotFoundException("Quantitative indicators does not exist");
        }
        return privateQuantitativeIndicators;
    }

    private static void createQuantitativeIndicators(){
        QuantitativeIndicator rateOfIncreaseInIndustrialProduction = new QuantitativeIndicator("Темп приросту (зниження) промислового обсягу виробництва (%)", factors.get(0));
        quantitativeIndicators.add(rateOfIncreaseInIndustrialProduction);
        QuantitativeIndicator rateOfIncreaseInProductionCosts = new QuantitativeIndicator("Темп приросту (зниження) собівартості продукції (%)", factors.get(0));
        quantitativeIndicators.add(rateOfIncreaseInProductionCosts);
        QuantitativeIndicator specificGravityOfTheCostOfProductionInTheTotalCost = new QuantitativeIndicator("Питома вага собівартості продукції у загальній сумі витрат (%)", factors.get(0));
        quantitativeIndicators.add(specificGravityOfTheCostOfProductionInTheTotalCost);
        QuantitativeIndicator costsFor1UAHOfSoldProducts = new QuantitativeIndicator("Ватрати на 1 грн. реалізованої продукції", factors.get(0));
        quantitativeIndicators.add(costsFor1UAHOfSoldProducts);
        QuantitativeIndicator laborProductivity = new QuantitativeIndicator("Продуктивність праці (тис.грн./чол)", factors.get(0));
        quantitativeIndicators.add(laborProductivity);

        QuantitativeIndicator rateOfIncomeGrowth = new QuantitativeIndicator("Темп приросту (зниження) доходів (%)", factors.get(1));
        quantitativeIndicators.add(rateOfIncomeGrowth);
        QuantitativeIndicator rateOfGrowthOfExpenses = new QuantitativeIndicator("Темп приросту (зниження) витрат (%)", factors.get(1));
        quantitativeIndicators.add(rateOfGrowthOfExpenses);
        QuantitativeIndicator theRatioOfReturnOnSalesToTheAmountOfAssets = new QuantitativeIndicator("Відношення прибутку від реалізації до суми активів", factors.get(1));
        quantitativeIndicators.add(theRatioOfReturnOnSalesToTheAmountOfAssets);
        QuantitativeIndicator turnoverOfAccountsReceivable = new QuantitativeIndicator("Оборотність дебіторської заборгованості (обор)", factors.get(1));
        quantitativeIndicators.add(turnoverOfAccountsReceivable);
        QuantitativeIndicator repaymentPeriodOfAccountsReceivable = new QuantitativeIndicator("Період погашення дебіторської заборгованості (дні)", factors.get(1));
        quantitativeIndicators.add(repaymentPeriodOfAccountsReceivable);
        QuantitativeIndicator turnoverOfAccountsPayable = new QuantitativeIndicator("Оборотність кредиторської заборгованості (обор)", factors.get(1));
        quantitativeIndicators.add(turnoverOfAccountsPayable);
        QuantitativeIndicator repaymentPeriodOfAccountsPayable = new QuantitativeIndicator("Період погашення кредиторської заборгованості (дні)", factors.get(1));
        quantitativeIndicators.add(repaymentPeriodOfAccountsPayable);
        QuantitativeIndicator durationOfTheOperatingCycle = new QuantitativeIndicator("Тривалість операційного циклу, днів", factors.get(1));
        quantitativeIndicators.add(durationOfTheOperatingCycle);
        QuantitativeIndicator durationOfTheFinancialCycle = new QuantitativeIndicator("Тривалість фінансового циклу, днів", factors.get(1));
        quantitativeIndicators.add(durationOfTheFinancialCycle);
        QuantitativeIndicator theRatioOfRapidlyRealizedAssetsToTheAmountOfAssets = new QuantitativeIndicator("Відношення швидко реалізованих активів до суми активів", factors.get(1));
        quantitativeIndicators.add(theRatioOfRapidlyRealizedAssetsToTheAmountOfAssets);
        QuantitativeIndicator theRatioOfWorkingCapitalToSalesProceeds = new QuantitativeIndicator("Відношення оборотного капіталу до виручки від реалізації", factors.get(1));
        quantitativeIndicators.add(theRatioOfWorkingCapitalToSalesProceeds);

        QuantitativeIndicator f31 = new QuantitativeIndicator("Рентабельність активів (%)", factors.get(2));
        quantitativeIndicators.add(f31);
        QuantitativeIndicator f32 = new QuantitativeIndicator("Рентабельність власного капіталу(%)", factors.get(2));
        quantitativeIndicators.add(f32);
        QuantitativeIndicator f33 = new QuantitativeIndicator("Рентабельність продажу (%)", factors.get(2));
        quantitativeIndicators.add(f33);
        QuantitativeIndicator f34 = new QuantitativeIndicator("Рентабельність чистих актвів (%)", factors.get(2));
        quantitativeIndicators.add(f34);
        QuantitativeIndicator f35 = new QuantitativeIndicator("Рентабельність власного капіталу (%)", factors.get(2));
        quantitativeIndicators.add(f35);
        QuantitativeIndicator f36 = new QuantitativeIndicator("Рентабельність реалізованих товарів, робіт послуг (%)", factors.get(2));
        quantitativeIndicators.add(f36);
        QuantitativeIndicator f37 = new QuantitativeIndicator("Рентабельність оборотних активів (%)", factors.get(2));
        quantitativeIndicators.add(f37);
        QuantitativeIndicator f38 = new QuantitativeIndicator("Відношення виручки від реалізації до швидко реалізованих активів", factors.get(2));
        quantitativeIndicators.add(f38);
        QuantitativeIndicator f39 = new QuantitativeIndicator("Відношення прибутку до сплати податків до суми активів (%)", factors.get(2));
        quantitativeIndicators.add(f39);
        QuantitativeIndicator f310 = new QuantitativeIndicator("Власний оборотний капітал", factors.get(2));
        quantitativeIndicators.add(f310);
        QuantitativeIndicator f311 = new QuantitativeIndicator("Відношення власного оборотного капіталу до суми активів", factors.get(2));
        quantitativeIndicators.add(f311);
        QuantitativeIndicator f312 = new QuantitativeIndicator("Відношення зобовязань до власного капіталу", factors.get(2));
        quantitativeIndicators.add(f312);
        QuantitativeIndicator f313 = new QuantitativeIndicator("Відношення власного капіталу до залученого", factors.get(2));
        quantitativeIndicators.add(f313);
        QuantitativeIndicator f314 = new QuantitativeIndicator("Оборотність активів", factors.get(2));
        quantitativeIndicators.add(f314);
        QuantitativeIndicator f315 = new QuantitativeIndicator("Частка мобільних активів у загальній величині майна підприємства", factors.get(2));
        quantitativeIndicators.add(f315);
        QuantitativeIndicator f316 = new QuantitativeIndicator("Відношення оборотного капіталу до суми активів", factors.get(2));
        quantitativeIndicators.add(f316);
        QuantitativeIndicator f317 = new QuantitativeIndicator("Коефіцієнт заборгованості", factors.get(2));
        quantitativeIndicators.add(f317);
        QuantitativeIndicator f318 = new QuantitativeIndicator("Відношення основного капіталу до суми чистих активів", factors.get(2));
        quantitativeIndicators.add(f318);
        QuantitativeIndicator f319 = new QuantitativeIndicator("Показники абсолютної платоспроможності", factors.get(2));
        quantitativeIndicators.add(f319);
        QuantitativeIndicator f320 = new QuantitativeIndicator("Показники проміжної платоспроможності", factors.get(2));
        quantitativeIndicators.add(f320);
        QuantitativeIndicator f321 = new QuantitativeIndicator("Показники загальної платоспроможності", factors.get(2));
        quantitativeIndicators.add(f321);
        QuantitativeIndicator f322 = new QuantitativeIndicator("Коефіцієнт фінансової незалежності (автономії)", factors.get(2));
        quantitativeIndicators.add(f322);
        QuantitativeIndicator f323 = new QuantitativeIndicator("Питома вага фінансових інвестицій в загальній сумі активів (%)", factors.get(2));
        quantitativeIndicators.add(f323);
        QuantitativeIndicator f324 = new QuantitativeIndicator("Прибутковість фінансових інвестицій", factors.get(2));
        quantitativeIndicators.add(f324);

        QuantitativeIndicator f41 = new QuantitativeIndicator("Плинність кадрів", factors.get(3));
        quantitativeIndicators.add(f41);
        QuantitativeIndicator f42 = new QuantitativeIndicator("Середньомісячна заробітна плата", factors.get(3));
        quantitativeIndicators.add(f42);
        QuantitativeIndicator f43 = new QuantitativeIndicator("Темп зростання (зниження) середньомісячної заробітної плати (%)", factors.get(3));
        quantitativeIndicators.add(f43);

        QuantitativeIndicator f51 = new QuantitativeIndicator("Рентабельність продажу", factors.get(4));
        quantitativeIndicators.add(f51);
        QuantitativeIndicator f52 = new QuantitativeIndicator("Місткість ринку", factors.get(4));
        quantitativeIndicators.add(f52);
        QuantitativeIndicator f53 = new QuantitativeIndicator("Оборотність товарно-матеріальних запасів", factors.get(4));
        quantitativeIndicators.add(f53);
        QuantitativeIndicator f54 = new QuantitativeIndicator("Період обороту товарно-матеріальних запасів", factors.get(4));
        quantitativeIndicators.add(f54);
        QuantitativeIndicator f55 = new QuantitativeIndicator("Маржинальний дохід", factors.get(4));
        quantitativeIndicators.add(f55);

        QuantitativeIndicator f61 = new QuantitativeIndicator("Частку приросту продукції за рахунок інтенсифікації виробництва", factors.get(5));
        quantitativeIndicators.add(f61);
    }

    @Override
    public List<Factor> getFactors(){
        List<Factor> privateFactors = new ArrayList<>();
        Collections.copy(privateFactors, factors);
        if (privateFactors.isEmpty()) {
            throw new EntityNotFoundException("Factors does not exist");
        }
        return privateFactors;
    }

    private static void createFactors(){
        Factor productionFactor = new Factor("Виробничий фактор");
        Factor managementFactor = new Factor("Управлінський фактор");
        Factor financialFactor = new Factor("Фінансовий фактор");
        Factor personnelFactor = new Factor("Кадровий фактор");
        Factor marketingFactor = new Factor("Маркетинговий фактор");
        Factor innovationFactor = new Factor("Інноваційний фактор");
        factors.add(productionFactor);
        factors.add(managementFactor);
        factors.add(financialFactor);
        factors.add(personnelFactor);
        factors.add(marketingFactor);
        factors.add(innovationFactor);
    }

    @Override
    public List<PreQuantitativeIndicator> getPreQuantitativeIndicators(List<QuantitativeIndicator> quantitativeIndicators){
        if (quantitativeIndicators.isEmpty()) {
            throw new EntityNotFoundException("This list of quantitative indicators is empty");
        }
        List<PreQuantitativeIndicator> privatePreQuantitativeIndicators = new ArrayList<>();
        for(QuantitativeIndicator quantitativeIndicator: quantitativeIndicators){
            for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                for(int k=0; k<preQuantitativeIndicator.getQuantitativeIndicators().size(); k++){
                    if(preQuantitativeIndicator.getQuantitativeIndicators().get(k).getName().equals(quantitativeIndicator.getName())){
                        privatePreQuantitativeIndicators.add(preQuantitativeIndicator);

                    }
                }
            }
        }
        if (privatePreQuantitativeIndicators.isEmpty()) {
            throw new EntityNotFoundException("Those indicators does not exist");
        }
        return privatePreQuantitativeIndicators;
    }

    private static void createPreQuantitativeIndicators(){
        PreQuantitativeIndicator finalValueOfProduction = new PreQuantitativeIndicator("Кінцеве значення обсягу виробництва", Collections.singletonList(quantitativeIndicators.get(0)));
        preQuantitativeIndicators.add(finalValueOfProduction);
        PreQuantitativeIndicator initialValueOfOutput = new PreQuantitativeIndicator("Початкове значення обсягу виробництва", Collections.singletonList(quantitativeIndicators.get(0)));
        preQuantitativeIndicators.add(initialValueOfOutput);
        PreQuantitativeIndicator theUltimateCostOfProduction = new PreQuantitativeIndicator("Кінцеве значення собівартості продукції", Collections.singletonList(quantitativeIndicators.get(1)));
        preQuantitativeIndicators.add(theUltimateCostOfProduction);
        PreQuantitativeIndicator initialValueOfProductionCost = new PreQuantitativeIndicator("Початкове значення собівартості продукції", Collections.singletonList(quantitativeIndicators.get(1)));
        preQuantitativeIndicators.add(initialValueOfProductionCost);
        PreQuantitativeIndicator costOfProductionForThePeriod = new PreQuantitativeIndicator("Собівартість продукції за період", Collections.singletonList(quantitativeIndicators.get(2)));
        preQuantitativeIndicators.add(costOfProductionForThePeriod);
        PreQuantitativeIndicator totalAmountOfExpensesForThePeriod = new PreQuantitativeIndicator("Загальна сума витрат за період", Collections.singletonList(quantitativeIndicators.get(2)));
        preQuantitativeIndicators.add(totalAmountOfExpensesForThePeriod);
        PreQuantitativeIndicator netIncomeFromSalesOfProducts = new PreQuantitativeIndicator("Чистий дохід від реалізації продукції", Collections.singletonList(quantitativeIndicators.get(3)));
        preQuantitativeIndicators.add(netIncomeFromSalesOfProducts);
        PreQuantitativeIndicator costOfSoldProducts = new PreQuantitativeIndicator("Собівартість реалізованої продукції", Arrays.asList(quantitativeIndicators.get(3),quantitativeIndicators.get(10),quantitativeIndicators.get(21),quantitativeIndicators.get(45)));
        preQuantitativeIndicators.add(costOfSoldProducts);
        PreQuantitativeIndicator netProceeds = new PreQuantitativeIndicator("Чиста виручка", Arrays.asList(quantitativeIndicators.get(4),quantitativeIndicators.get(18),quantitativeIndicators.get(43)));
        preQuantitativeIndicators.add(netProceeds);
        PreQuantitativeIndicator averageAnnualNumberOfEmployees = new PreQuantitativeIndicator("Середньорічна кількість працівників", Collections.singletonList(quantitativeIndicators.get(4)));
        preQuantitativeIndicators.add(averageAnnualNumberOfEmployees);
        PreQuantitativeIndicator theFinalValueOfIncome = new PreQuantitativeIndicator("Кінцеве значення доходів", Collections.singletonList(quantitativeIndicators.get(5)));
        preQuantitativeIndicators.add(theFinalValueOfIncome);
        PreQuantitativeIndicator initialValueOfRevenues = new PreQuantitativeIndicator("Початкове значення доходів", Collections.singletonList(quantitativeIndicators.get(5)));
        preQuantitativeIndicators.add(initialValueOfRevenues);
        PreQuantitativeIndicator finalCostValue = new PreQuantitativeIndicator("Кінцеве значення витрат", Collections.singletonList(quantitativeIndicators.get(6)));
        preQuantitativeIndicators.add(finalCostValue);
        PreQuantitativeIndicator initialCostValue = new PreQuantitativeIndicator("Початкове значення витрат", Collections.singletonList(quantitativeIndicators.get(6)));
        preQuantitativeIndicators.add(initialCostValue);
        PreQuantitativeIndicator profitFromSales = new PreQuantitativeIndicator("Прибуток від реалізації", Collections.singletonList(quantitativeIndicators.get(7)));
        preQuantitativeIndicators.add(profitFromSales);
        PreQuantitativeIndicator amountOfAssets = new PreQuantitativeIndicator("Сума активів", Arrays.asList(quantitativeIndicators.get(7),quantitativeIndicators.get(14),quantitativeIndicators.get(24),quantitativeIndicators.get(26),quantitativeIndicators.get(30),quantitativeIndicators.get(31),quantitativeIndicators.get(32),quantitativeIndicators.get(37),quantitativeIndicators.get(38)));
        preQuantitativeIndicators.add(amountOfAssets);
        PreQuantitativeIndicator revenueFromSales = new PreQuantitativeIndicator("Виручка від реалізації", Arrays.asList(quantitativeIndicators.get(8),quantitativeIndicators.get(15),quantitativeIndicators.get(23),quantitativeIndicators.get(29),quantitativeIndicators.get(48)));
        preQuantitativeIndicators.add(revenueFromSales);
        PreQuantitativeIndicator averageAnnualValueOfAccountsReceivable = new PreQuantitativeIndicator("Середньорічна вартість дебіторської заборгованості", Collections.singletonList(quantitativeIndicators.get(8)));
        preQuantitativeIndicators.add(averageAnnualValueOfAccountsReceivable);
        PreQuantitativeIndicator numberOfDaysInThePeriod = new PreQuantitativeIndicator("Кількість днів у періоді", Arrays.asList(quantitativeIndicators.get(9),quantitativeIndicators.get(11),quantitativeIndicators.get(46)));
        preQuantitativeIndicators.add(numberOfDaysInThePeriod);
        PreQuantitativeIndicator turnoverOfAccountsReceivable = new PreQuantitativeIndicator("Оборотність дебіторської заборгованості", Collections.singletonList(quantitativeIndicators.get(9)));
        preQuantitativeIndicators.add(turnoverOfAccountsReceivable);
        PreQuantitativeIndicator averageAnnualCostOfAccountsPayable = new PreQuantitativeIndicator("Середньорічна вартість кредиторської заборгованості", Collections.singletonList(quantitativeIndicators.get(10)));
        preQuantitativeIndicators.add(averageAnnualCostOfAccountsPayable);
        PreQuantitativeIndicator turnoverOfAccountsPayable = new PreQuantitativeIndicator("Оборотність кредиторської заборгованості", Collections.singletonList(quantitativeIndicators.get(11)));
        preQuantitativeIndicators.add(turnoverOfAccountsPayable);
        PreQuantitativeIndicator repaymentPeriodOfAccountsReceivable = new PreQuantitativeIndicator("Період погашення дебіторської заборгованості", Arrays.asList(quantitativeIndicators.get(12),quantitativeIndicators.get(13)));
        preQuantitativeIndicators.add(repaymentPeriodOfAccountsReceivable);
        PreQuantitativeIndicator periodOfTurnoverOfInventories = new PreQuantitativeIndicator("Період обороту товарно-матеріальних запасів", Arrays.asList(quantitativeIndicators.get(12),quantitativeIndicators.get(13)));
        preQuantitativeIndicators.add(periodOfTurnoverOfInventories);
        PreQuantitativeIndicator thePeriodOfRepaymentOfDebts = new PreQuantitativeIndicator("Період погашення кредиторської заборгованості", Collections.singletonList(quantitativeIndicators.get(13)));
        preQuantitativeIndicators.add(thePeriodOfRepaymentOfDebts);
        PreQuantitativeIndicator quicklyRealizedAssets = new PreQuantitativeIndicator("Швидко реалізовані активи", Arrays.asList(quantitativeIndicators.get(14),quantitativeIndicators.get(23)));
        preQuantitativeIndicators.add(quicklyRealizedAssets);
        PreQuantitativeIndicator workingCapital = new PreQuantitativeIndicator("Оборотний капітал", Arrays.asList(quantitativeIndicators.get(15),quantitativeIndicators.get(31)));
        preQuantitativeIndicators.add(workingCapital);
        PreQuantitativeIndicator netProfit = new PreQuantitativeIndicator("Чистий прибуток", Arrays.asList(quantitativeIndicators.get(16),quantitativeIndicators.get(17),quantitativeIndicators.get(19),quantitativeIndicators.get(20),quantitativeIndicators.get(21)));
        preQuantitativeIndicators.add(netProfit);
        PreQuantitativeIndicator averageAnnualValueOfAssets = new PreQuantitativeIndicator("Середньорічна вартість активів", Arrays.asList(quantitativeIndicators.get(16),quantitativeIndicators.get(29)));
        preQuantitativeIndicators.add(averageAnnualValueOfAssets);
        PreQuantitativeIndicator averageAnnualCostOfEquityCapital = new PreQuantitativeIndicator("Середньорічна вартість власного капіталу", Collections.singletonList(quantitativeIndicators.get(17)));
        preQuantitativeIndicators.add(averageAnnualCostOfEquityCapital);
        PreQuantitativeIndicator operatingProfit = new PreQuantitativeIndicator("Операційний прибуток", Arrays.asList(quantitativeIndicators.get(18),quantitativeIndicators.get(22),quantitativeIndicators.get(43)));
        preQuantitativeIndicators.add(operatingProfit);
        PreQuantitativeIndicator averageAnnualValueOfNetAssets = new PreQuantitativeIndicator("Середньорічна вартість чистих активів", Collections.singletonList(quantitativeIndicators.get(19)));
        preQuantitativeIndicators.add(averageAnnualValueOfNetAssets);
        PreQuantitativeIndicator equityCapital = new PreQuantitativeIndicator("Власний капітал", Arrays.asList(quantitativeIndicators.get(20),quantitativeIndicators.get(25),quantitativeIndicators.get(27),quantitativeIndicators.get(28),quantitativeIndicators.get(37)));
        preQuantitativeIndicators.add(equityCapital);
        PreQuantitativeIndicator averageAnnualValueOfCurrentAssets = new PreQuantitativeIndicator("Середньорічна вартість оборотних активів", Collections.singletonList(quantitativeIndicators.get(22)));
        preQuantitativeIndicators.add(averageAnnualValueOfCurrentAssets);
        PreQuantitativeIndicator profitBeforeTax = new PreQuantitativeIndicator("Прибуток до сплати податків", Collections.singletonList(quantitativeIndicators.get(24)));
        preQuantitativeIndicators.add(profitBeforeTax);
        PreQuantitativeIndicator nonCurrentAssets = new PreQuantitativeIndicator("Необоротні активи", Arrays.asList(quantitativeIndicators.get(25),quantitativeIndicators.get(33)));
        preQuantitativeIndicators.add(nonCurrentAssets);
        PreQuantitativeIndicator ownWorkingCapital = new PreQuantitativeIndicator("Власний оборотний капітал", Collections.singletonList(quantitativeIndicators.get(26)));
        preQuantitativeIndicators.add(ownWorkingCapital);
        PreQuantitativeIndicator obligation = new PreQuantitativeIndicator("Зобов’язання", Collections.singletonList(quantitativeIndicators.get(27)));
        preQuantitativeIndicators.add(obligation);
        PreQuantitativeIndicator capitalAttracted = new PreQuantitativeIndicator("Залучений капітал", Arrays.asList(quantitativeIndicators.get(28),quantitativeIndicators.get(32)));
        preQuantitativeIndicators.add(capitalAttracted);
        PreQuantitativeIndicator currentAssets = new PreQuantitativeIndicator("Оборотні активи", Arrays.asList(quantitativeIndicators.get(30),quantitativeIndicators.get(35),quantitativeIndicators.get(36)));
        preQuantitativeIndicators.add(currentAssets);
        PreQuantitativeIndicator netAssets = new PreQuantitativeIndicator("Чисті активи", Collections.singletonList(quantitativeIndicators.get(33)));
        preQuantitativeIndicators.add(netAssets);
        PreQuantitativeIndicator cash = new PreQuantitativeIndicator("Грошові кошти", Collections.singletonList(quantitativeIndicators.get(34)));
        preQuantitativeIndicators.add(cash);
        PreQuantitativeIndicator currentLiabilities = new PreQuantitativeIndicator("Поточні зобов'язання", Arrays.asList(quantitativeIndicators.get(34),quantitativeIndicators.get(35),quantitativeIndicators.get(36)));
        preQuantitativeIndicators.add(currentLiabilities);
        PreQuantitativeIndicator inventories = new PreQuantitativeIndicator("Товарно-матеріальні запаси", Collections.singletonList(quantitativeIndicators.get(35)));
        preQuantitativeIndicators.add(inventories);
        PreQuantitativeIndicator financialInvestments = new PreQuantitativeIndicator("Фінансові інвестиції", Arrays.asList(quantitativeIndicators.get(38),quantitativeIndicators.get(39)));
        preQuantitativeIndicators.add(financialInvestments);
        PreQuantitativeIndicator profit = new PreQuantitativeIndicator("Прибуток", Collections.singletonList(quantitativeIndicators.get(39)));
        preQuantitativeIndicators.add(profit);
        PreQuantitativeIndicator numberOfDismissedWorkers = new PreQuantitativeIndicator("Кількість звільнених працівників", Collections.singletonList(quantitativeIndicators.get(40)));
        preQuantitativeIndicators.add(numberOfDismissedWorkers);
        PreQuantitativeIndicator averageNumberOfStaff = new PreQuantitativeIndicator("Середньооблікова чисельність персоналу", Arrays.asList(quantitativeIndicators.get(40),quantitativeIndicators.get(41)));
        preQuantitativeIndicators.add(averageNumberOfStaff);
        PreQuantitativeIndicator payrollFund = new PreQuantitativeIndicator("Фонд оплати праці", Collections.singletonList(quantitativeIndicators.get(41)));
        preQuantitativeIndicators.add(payrollFund);
        PreQuantitativeIndicator finalValueOfTheAverageMonthlySalary = new PreQuantitativeIndicator("Кінцеве значення середньомісячної заробітної плати", Collections.singletonList(quantitativeIndicators.get(42)));
        preQuantitativeIndicators.add(finalValueOfTheAverageMonthlySalary);
        PreQuantitativeIndicator initialValueOfTheAverageMonthlySalary  = new PreQuantitativeIndicator("Початкове значення середньомісячної заробітної плати", Collections.singletonList(quantitativeIndicators.get(42)));
        preQuantitativeIndicators.add(initialValueOfTheAverageMonthlySalary);
        PreQuantitativeIndicator volumeOfProduction = new PreQuantitativeIndicator("Обсяг виробництва продукції", Collections.singletonList(quantitativeIndicators.get(44)));
        preQuantitativeIndicators.add(volumeOfProduction);
        PreQuantitativeIndicator productResidues = new PreQuantitativeIndicator("Залишки продукції", Collections.singletonList(quantitativeIndicators.get(44)));
        preQuantitativeIndicators.add(productResidues);
        PreQuantitativeIndicator productImport = new PreQuantitativeIndicator("Імпорт", Collections.singletonList(quantitativeIndicators.get(44)));
        preQuantitativeIndicators.add(productImport);
        PreQuantitativeIndicator productExport = new PreQuantitativeIndicator("Експорт", Collections.singletonList(quantitativeIndicators.get(44)));
        preQuantitativeIndicators.add(productExport);
        PreQuantitativeIndicator averageAnnualCostOfInventory = new PreQuantitativeIndicator("Середньорічна вартість товарно-матеріальних запасів", Collections.singletonList(quantitativeIndicators.get(45)));
        preQuantitativeIndicators.add(averageAnnualCostOfInventory);
        PreQuantitativeIndicator turnoverOfInventory = new PreQuantitativeIndicator("Оборотність товарно-матеріальних запасів", Collections.singletonList(quantitativeIndicators.get(46)));
        preQuantitativeIndicators.add(turnoverOfInventory);
        PreQuantitativeIndicator variableCosts = new PreQuantitativeIndicator("Змінні витрати", Collections.singletonList(quantitativeIndicators.get(47)));
        preQuantitativeIndicators.add(variableCosts);
        PreQuantitativeIndicator WZ = new PreQuantitativeIndicator("Приріст застосовуваних ресурсів за певний період, %", Collections.singletonList(quantitativeIndicators.get(48)));
        preQuantitativeIndicators.add(WZ);
        PreQuantitativeIndicator WP = new PreQuantitativeIndicator("Приріст обсягу виробництва продукції за певний період, %", Collections.singletonList(quantitativeIndicators.get(48)));
        preQuantitativeIndicators.add(WP);
    }

    @Override
    public List<QuantitativeIndicator> calculateAmountOfQuantitativeIndicators(InDataForCalculationQuantitativeIndicatorAmount inDataForCalculationQuantitativeIndicatorAmount){
        List<QuantitativeIndicator> quantitativeIndicators = inDataForCalculationQuantitativeIndicatorAmount.getQuantitativeIndicators();
        List<PreQuantitativeIndicator> preQuantitativeIndicators = inDataForCalculationQuantitativeIndicatorAmount.getPreQuantitativeIndicators();
        if(isNull(quantitativeIndicators) || isNull(preQuantitativeIndicators)){
            throw new EntityNotFoundException("This data does not exist or not full");
        }
        for(QuantitativeIndicator quantitativeIndicator: quantitativeIndicators){
            double value1 = 0;
            double value2 = 0;
            double value3 = 0;
            double value4 = 0;
            switch (quantitativeIndicator.getName()){
                case "Темп приросту (зниження) промислового обсягу виробництва (%)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Кінцеве значення обсягу виробництва")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Початкове значення обсягу виробництва")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount((value1-value2)/value2*100);
                    break;
                case "Темп приросту (зниження) собівартості продукції (%)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Кінцеве значення собівартості продукції")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Початкове значення собівартості продукції")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount((value1-value2)/value2*100);
                    break;
                case "Питома вага собівартості продукції у загальній сумі витрат (%)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Собівартість продукції за період")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Загальна сума витрат за період")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2*100);
                    break;
                case "Ватрати на 1 грн. реалізованої продукції":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Чистий дохід від реалізації продукції")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Собівартість реалізованої продукції")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Продуктивність праці (тис.грн./чол)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Чиста виручка")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Середньорічна кількість працівників")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Темп приросту (зниження) доходів (%)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Кінцеве значення доходів")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Початкове значення доходів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount((value1-value2)/value2*100);
                    break;
                case "Темп приросту (зниження) витрат (%)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Кінцеве значення витрат")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Початкове значення витрат")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount((value1-value2)/value2*100);
                    break;
                case "Відношення прибутку від реалізації до суми активів":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Прибуток від реалізації")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Сума активів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Оборотність дебіторської заборгованості (обор)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Виручка від реалізації")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Середньорічна вартість дебіторської заборгованості")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Період погашення дебіторської заборгованості (дні)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Кількість днів у періоді")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Оборотність дебіторської заборгованості")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Оборотність кредиторської заборгованості (обор)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Собівартість реалізованої продукції")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Середньорічна вартість кредиторської заборгованості")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Період погашення кредиторської заборгованості (дні)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Кількість днів у періоді")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Оборотність кредиторської заборгованості")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Тривалість операційного циклу, днів":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Період погашення дебіторської заборгованості")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Період обороту товарно-матеріальних запасів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1+value2);
                    break;
                case "Тривалість фінансового циклу, днів":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Період погашення дебіторської заборгованості")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Період обороту товарно-матеріальних запасів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Період погашення кредиторської заборгованості")){
                            value3 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1+value2-value3);
                    break;
                case "Відношення швидко реалізованих активів до суми активів":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Швидко реалізовані активи")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Сума активів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Відношення оборотного капіталу до виручки від реалізації":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Оборотний капітал")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Виручка від реалізації")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Рентабельність активів (%)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Чистий прибуток")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Середньорічна вартість активів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2*100);
                    break;
                case "Рентабельність власного капіталу(%)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Чистий прибуток")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Середньорічна вартість власного капіталу")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2*100);
                    break;
                case "Рентабельність продажу (%)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Операційний прибуток")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Чиста виручка")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2*100);
                    break;
                case "Рентабельність чистих актвів (%)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Чистий прибуток")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Середньорічна вартість чистих активів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2*100);
                    break;
                case "Рентабельність власного капіталу (%)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Чистий прибуток")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Власний капітал")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2*100);
                    break;
                case "Рентабельність реалізованих товарів, робіт послуг (%)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Чистий прибуток")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Собівартість реалізованої продукції")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2*100);
                    break;
                case "Рентабельність оборотних активів (%)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Операційний прибуток")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Середньорічна вартість оборотних активів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2*100);
                    break;
                case "Відношення виручки від реалізації до швидко реалізованих активів":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Виручка від реалізації")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Швидко реалізовані активи")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Відношення прибутку до сплати податків до суми активів (%)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Прибуток до сплати податків")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Сума активів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Власний оборотний капітал":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Власний капітал")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Необоротні активи")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1-value2);
                    break;
                case "Відношення власного оборотного капіталу до суми активів":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Власний оборотний капітал")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Сума активів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Відношення зобовязань до власного капіталу":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Зобов’язання")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Власний капітал")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Відношення власного капіталу до залученого":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Власний капітал")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Залучений капітал")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Оборотність активів":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Виручка від реалізації")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Середньорічна вартість активів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Частка мобільних активів у загальній величині майна підприємства":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Оборотні активи")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Сума активів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Відношення оборотного капіталу до суми активів":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Оборотний капітал")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Сума активів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Коефіцієнт заборгованості":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Залучений капітал")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Сума активів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Відношення основного капіталу до суми чистих активів":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Необоротні активи")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Чисті активи")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Показники абсолютної платоспроможності":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Грошові кошти")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Поточні зобов'язання")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Показники проміжної платоспроможності":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Оборотні активи")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Товарно-матеріальні запаси")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Поточні зобов'язання")){
                            value3 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount((value1-value2)/value3);
                    break;
                case "Показники загальної платоспроможності":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Оборотні активи")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Поточні зобов'язання")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Коефіцієнт фінансової незалежності (автономії)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Власний капітал")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Сума активів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Питома вага фінансових інвестицій в загальній сумі активів (%)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Фінансові інвестиції")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Сума активів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2*100);
                    break;
                case "Прибутковість фінансових інвестицій":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Прибуток")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Фінансові інвестиції")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Плинність кадрів":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Кількість звільнених працівників")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Середньооблікова чисельність персоналу")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2*100);
                    break;
                case "Середньомісячна заробітна плата":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Фонд оплати праці")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Середньооблікова чисельність персоналу")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2/12);
                    break;
                case "Темп зростання (зниження) середньомісячної заробітної плати (%)":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Кінцеве значення середньомісячної заробітної плати")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Початкове значення середньомісячної заробітної плати")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount((value1-value2)/value2*100);
                    break;
                case "Рентабельність продажу":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Операційний прибуток")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Чиста виручка")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Місткість ринку":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Обсяг виробництва продукції")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Залишки продукції")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Імпорт")){
                            value3 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Експорт")){
                            value4 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1+value2+value3-value4);
                    break;
                case "Оборотність товарно-матеріальних запасів":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Собівартість реалізованої продукції")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Середньорічна вартість товарно-матеріальних запасів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Період обороту товарно-матеріальних запасів":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Кількість днів у періоді")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Оборотність товарно-матеріальних запасів")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1/value2);
                    break;
                case "Маржинальний дохід":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Виручка від реалізації")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Змінні витрати")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(value1-value2);
                    break;
                case "Частку приросту продукції за рахунок інтенсифікації виробництва":
                    for(PreQuantitativeIndicator preQuantitativeIndicator: preQuantitativeIndicators){
                        if(preQuantitativeIndicator.getName().equals("Приріст застосовуваних ресурсів за певний період, %")){
                            value1 = preQuantitativeIndicator.getAmount();
                        }
                        if(preQuantitativeIndicator.getName().equals("Приріст обсягу виробництва продукції за певний період, %")){
                            value2 = preQuantitativeIndicator.getAmount();
                        }
                    }
                    quantitativeIndicator.setAmount(100*(1-value1/value2));
                    break;
                default: break;

            }
        }
        return quantitativeIndicators;
    }

    @Override
    public List<Factor> calculateFactorsPoints(Company company, List<List<Indicator>> factorIndicators, List<List<String>> dependencies){
        if(factorIndicators.isEmpty() || dependencies.isEmpty()){
            throw new EntityNotFoundException("Requested data does not exist or not full");
        }
        List<Factor> factorList = new ArrayList<>();
        for(int i = 0; i<factorIndicators.size(); i++){
            Factor factor = factorIndicators.get(i).get(0).getFactor();
            List<LinguisticAssessment> assessments = new ArrayList<>();
            for(Indicator factorIndicator: factorIndicators.get(i)){
                assessments.add(factorIndicator.getAssessment());
            }

            factorList.add(calculateAssessmentPoints(company, factor, assessments, dependencies.get(i)));
        }
        return factorList;
    }

    @Override
    public Factor calculateCompanyPoints(Company company, List<Factor> factors, List<String> factorDependencies){
        if(factorDependencies.isEmpty()){
            throw new EntityNotFoundException("Requested data does not exist");
        }
        Factor factor = new Factor("Стан підприємства");
        List<LinguisticAssessment> assessments = new ArrayList<>();
        for(Factor factorFromList: factors){
            assessments.add(factorFromList.getAssessment());
        }

        return calculateAssessmentPoints(company, factor, assessments, factorDependencies);
    }

    private Factor calculateAssessmentPoints(Company company, Factor factor, List<LinguisticAssessment> assessments, List<String> factorDependencies){
        double[] r = new double[assessments.size()];
        r[assessments.size()-1] = 1;
        if(assessments.size()>1){
            for(int i = assessments.size()-1; i>0; i--){
                if(factorDependencies.get(i-1).equals("=")){
                    r[i-1] = r[i];
                }
                else {
                    r[i-1] = r[i]+1;
                }
            }
        }

        double K = 0;
        for (int i = 0; i<assessments.size(); i++){
            K = K+r[i];
        }

        double[] p = new double[assessments.size()];
        for (int i = 0; i<assessments.size(); i++){
            p[i] = r[i]/K;
        }

        factor.setAssessment(new LinguisticAssessment());
        for(int i = 0; i<assessments.size(); i++){
            factor.getAssessment().setA(factor.getAssessment().getA()+assessments.get(i).getA()*p[i]);
            factor.getAssessment().setB(factor.getAssessment().getB()+assessments.get(i).getB()*p[i]);
            factor.getAssessment().setC(factor.getAssessment().getC()+assessments.get(i).getC()*p[i]);
            factor.getAssessment().setD(factor.getAssessment().getD()+assessments.get(i).getD()*p[i]);
        }

        LinguisticAssessment[] linguisticAssessments = {new LinguisticAssessment("Дуже низький"), new LinguisticAssessment("Низький"), new LinguisticAssessment("Середній"), new LinguisticAssessment("Високий"), new LinguisticAssessment("Дуже високий")};
        double[] a = new double[5];
        double[] b = new double[5];
        double[] c = new double[5];
        double[] d = new double[5];
        for(int i = 0; i<5; i++){
            a[i] = (double)Math.round((Math.abs(factor.getAssessment().getA()-linguisticAssessments[i].getA())) * 10000d) / 10000d;
            b[i] = (double)Math.round((Math.abs(factor.getAssessment().getB()-linguisticAssessments[i].getB())) * 10000d) / 10000d;
            c[i] = (double)Math.round((Math.abs(factor.getAssessment().getC()-linguisticAssessments[i].getC())) * 10000d) / 10000d;
            d[i] = (double)Math.round((Math.abs(factor.getAssessment().getD()-linguisticAssessments[i].getD())) * 10000d) / 10000d;
        }
        double minA = Math.min(a[0],a[1]);
        double minB = Math.min(b[0],b[1]);
        double minC = Math.min(c[0],c[1]);
        double minD = Math.min(d[0],d[1]);
        for(int i = 2; i<5; i++){
            minA = Math.min(minA,a[i]);
            minB = Math.min(minB,a[i]);
            minC = Math.min(minC,a[i]);
            minD = Math.min(minD,a[i]);
        }
        int[] minCount = new int[5];
        for(int i=0;i<5;i++){
            minCount[i]=0;
            if(minA==a[i])
                minCount[i]=minCount[i]+1;
            if(minB==b[i])
                minCount[i]=minCount[i]+1;
            if(minC==c[i])
                minCount[i]=minCount[i]+1;
            if(minD==d[i])
                minCount[i]=minCount[i]+1;
        }
        int maximum = Math.max(minCount[0],minCount[1]);
        for(int i=2;i<5;i++){
            maximum=Math.max(maximum,minCount[i]);
        }

        if(maximum==minCount[0])
            factor.getAssessment().setName("Дуже низький");
        if(maximum==minCount[1])
            factor.getAssessment().setName("Низький");
        if(maximum==minCount[2])
            factor.getAssessment().setName("Середній");
        if(maximum==minCount[3])
            factor.getAssessment().setName("Високий");
        if(maximum==minCount[4])
            factor.getAssessment().setName("Дуже високий");

        double v;
        if(factor.getAssessment().getName().equals("Дуже низький")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[0].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[0].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[0].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[0].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
            factor.setAssessmentPoint(v);
        }
        if(factor.getAssessment().getName().equals("Низький")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[1].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[1].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[1].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[1].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
            factor.setAssessmentPoint(v);
        }
        if(factor.getAssessment().getName().equals("Середній")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[2].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[2].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[2].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[2].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
            factor.setAssessmentPoint(v);
        }
        if(factor.getAssessment().getName().equals("Високий")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[3].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[3].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[3].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[3].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
            factor.setAssessmentPoint(v);
        }
        if(factor.getAssessment().getName().equals("Дуже високий")){
            double abcdv = Math.max(Math.abs(factor.getAssessment().getA()-linguisticAssessments[4].getA()), Math.abs(factor.getAssessment().getB()-linguisticAssessments[4].getB()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getC()-linguisticAssessments[4].getC()));
            abcdv = Math.min(abcdv, Math.abs(factor.getAssessment().getD()-linguisticAssessments[4].getD()));
            v = 1-abcdv;
            factor.getAssessment().setName(factor.getAssessment().getName()+"("+v+")");
            factor.setAssessmentPoint(v);
        }
        companyFactorRepository.saveAndFlush(new CompanyFactor(factor.getName(),factor.getAssessment().getName(), factor.getAssessmentPoint(), company));
        return factor;
    }

    @Override
    public MultiFactorModelOfAltman multiFactorModelOfAltmanResult(Company company, MultiFactorModelOfAltmanData multiFactorModelOfAltmanData){
        if(isNull(multiFactorModelOfAltmanData)){
            throw new EntityNotFoundException("Requested data of multi factor model of Altman does not exist");
        }
        double x1 = (multiFactorModelOfAltmanData.getCurrentAssets()-multiFactorModelOfAltmanData.getCurrentLiabilities())/multiFactorModelOfAltmanData.getTotalValueOfAssets();
        double x2 = multiFactorModelOfAltmanData.getNetProfit()/multiFactorModelOfAltmanData.getTotalValueOfAssets();
        double x3 = multiFactorModelOfAltmanData.getProfitBeforePayments()/multiFactorModelOfAltmanData.getTotalValueOfAssets();
        double x4 = multiFactorModelOfAltmanData.getBookValueOfEquity()/multiFactorModelOfAltmanData.getObligation();
        double x5 = multiFactorModelOfAltmanData.getReceipts()/multiFactorModelOfAltmanData.getTotalValueOfAssets();
        double z = 1.2*x1+1.4*x2+3.3*x3+0.6*x4+x5;

        MultiFactorModelOfAltman multiFactorModelOfAltman = new MultiFactorModelOfAltman(z,x1,x2,x3,x4,x5,company);
        multiFactorModelOfAltmanRepository.saveAndFlush(multiFactorModelOfAltman);
        return multiFactorModelOfAltman;
    }

    @Override
    public LissModel lissModelResult(Company company, LissModelData lissModelData){
        if(isNull(lissModelData)){
            throw new EntityNotFoundException("Requested data of liss model does not exist");
        }
        double x1 = lissModelData.getWorkingCapital()/lissModelData.getAmountOfAssets();
        double x2 = lissModelData.getProfitFromSales()/lissModelData.getAmountOfAssets();
        double x3 = lissModelData.getUndividedProfit()/lissModelData.getAmountOfAssets();
        double x4 = lissModelData.getEquityCapital()/lissModelData.getAttractedCapital();
        double z = 0.063*x1+0.092*x2+0.057*x3+0.001*x4;

        LissModel lissModel = new LissModel(z,x1,x2,x3,x4,company);
        lissModelRepository.saveAndFlush(lissModel);
        return lissModel;
    }

    @Override
    public DavidBelikovModel davidBelikovModelResult(Company company, DavidBelikovModelData davidBelikovModelData){
        if(isNull(davidBelikovModelData)){
            throw new EntityNotFoundException("Requested data of david-Belikov model does not exist");
        }
        double x1 = davidBelikovModelData.getCurrentAssets()/davidBelikovModelData.getTotalValueOfAssets();
        double x2 = davidBelikovModelData.getNetProfit()/davidBelikovModelData.getEquityCapital();
        double x3 = davidBelikovModelData.getReceipts()/davidBelikovModelData.getTotalValueOfAssets();
        double x4 = davidBelikovModelData.getNetProfit()/davidBelikovModelData.getCost();
        double z = 8.38*x1+1.0*x2+0.054*x3+0.63*x4;

        DavidBelikovModel davidBelikovModel = new DavidBelikovModel(z,x1,x2,x3,x4,company);
        davidBelikovModelRepository.saveAndFlush(davidBelikovModel);
        return davidBelikovModel;
    }

    @Override
    public SpringateModel springateModelResult(Company company, SpringateModelData springateModelData){
        if(isNull(springateModelData)){
            throw new EntityNotFoundException("Requested data of springate model does not exist");
        }
        double x1 = springateModelData.getWorkingCapital()/springateModelData.getTotalValueOfAssets();
        double x2 = springateModelData.getProfitFromSales()/springateModelData.getTotalValueOfAssets();
        double x3 = springateModelData.getProfitFromSales()/springateModelData.getShortTermDebt();
        double x4 = springateModelData.getSalesVolume()/springateModelData.getTotalValueOfAssets();
        double z = 1.03*x1+3.07*x2+0.66*x3+0.63*x4;

        SpringateModel springateModel = new SpringateModel(z,x1,x2,x3,x4,company);
        springateModelRepository.saveAndFlush(springateModel);
        return springateModel;

    }

    @Override
    public UniversalDiscriminatoryModel universalDiscriminatoryModelResult(Company company, UniversalDiscriminatoryModelData universalDiscriminatoryModelData){
        if(isNull(universalDiscriminatoryModelData)){
            throw new EntityNotFoundException("Requested data of universal discriminatory model does not exist");
        }
        double x1 = universalDiscriminatoryModelData.getCashFlow()/universalDiscriminatoryModelData.getObligation();
        double x2 = universalDiscriminatoryModelData.getTotalValueOfAssets()/universalDiscriminatoryModelData.getObligation();
        double x3 = universalDiscriminatoryModelData.getNetProfit()/universalDiscriminatoryModelData.getTotalValueOfAssets();
        double x4 = universalDiscriminatoryModelData.getNetProfit()/universalDiscriminatoryModelData.getReceipts();
        double x5 = universalDiscriminatoryModelData.getInventories()/universalDiscriminatoryModelData.getReceipts();
        double x6 = universalDiscriminatoryModelData.getReceipts()/universalDiscriminatoryModelData.getTotalValueOfAssets();
        double z = 1.5*x1+0.08*x2+10*x3+5*x4+0.3*x5+0.1*x6;

        UniversalDiscriminatoryModel universalDiscriminatoryModel = new UniversalDiscriminatoryModel(z,x1,x2,x3,x4,x5,x6,company);
        universalDiscriminatoryModelRepository.saveAndFlush(universalDiscriminatoryModel);
        return universalDiscriminatoryModel;

    }

    @Override
    public List<CompanyFactor> getNedosekinModelIndicatorsForCompany(Company company){
        return companyFactorRepository.findAllByCompany(company);
    }

    @Override
    public List<LissModel> getLissModelIndicatorsForCompany(Company company){
        return lissModelRepository.findAllByCompany(company);
    }

    @Override
    public List<DavidBelikovModel> getDavidBelikovModelIndicatorsForCompany(Company company){
        return davidBelikovModelRepository.findAllByCompany(company);
    }

    @Override
    public List<MultiFactorModelOfAltman> getMultiFactorModelOfAltmanIndicatorsForCompany(Company company){
        return multiFactorModelOfAltmanRepository.findAllByCompany(company);
    }

    @Override
    public List<SpringateModel> getSpringateModelIndicatorsForCompany(Company company){
        return springateModelRepository.findAllByCompany(company);
    }

    @Override
    public List<UniversalDiscriminatoryModel> getUniversalDiscriminatoryModelIndicatorsForCompany(Company company){
        return universalDiscriminatoryModelRepository.findAllByCompany(company);
    }
}
