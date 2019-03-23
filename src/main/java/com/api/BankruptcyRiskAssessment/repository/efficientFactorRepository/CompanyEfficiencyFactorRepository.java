package com.api.BankruptcyRiskAssessment.repository.efficientFactorRepository;

import com.api.BankruptcyRiskAssessment.entity.efficiencyFactor.CompanyEfficiencyFactor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyEfficiencyFactorRepository extends JpaRepository <CompanyEfficiencyFactor, Long> {

    List<CompanyEfficiencyFactor> findCompanyEfficiencyFactorByCompany_Edrpou(Integer edrpou);
    List<CompanyEfficiencyFactor> findCompanyEfficiencyFactorByCompany_CompanyNameLike(String companyName);

}
