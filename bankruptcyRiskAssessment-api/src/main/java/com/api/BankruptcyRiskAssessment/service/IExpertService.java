package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.ExpertAccess;
import com.api.BankruptcyRiskAssessment.entity.User;

import java.util.List;

public interface IExpertService {

    List<ExpertAccess> getCompaniesByExpert(Long userId);

    ExpertAccess addExpertAccess(ExpertAccess expertAccess);

    ExpertAccess getExpertAccess(Long expertAccessId);

    ExpertAccess updateExpertAccess(ExpertAccess expertAccess);

    ExpertAccess deleteExpertAccess(Long expertAccessId);

    List<ExpertAccess> getAllExpertAccess();

    List<User> getAllExperts();

}
