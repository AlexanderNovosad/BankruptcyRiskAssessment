package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.ExpertAccess;
import com.api.BankruptcyRiskAssessment.entity.Recommendation;
import com.api.BankruptcyRiskAssessment.entity.User;

import java.util.List;

public interface IExpertService {

    List<ExpertAccess> getAccessesByExpert(Long userId);

    ExpertAccess addExpertAccess(ExpertAccess expertAccess);

    ExpertAccess getExpertAccess(Long expertAccessId);

    ExpertAccess updateExpertAccess(ExpertAccess expertAccess);

    void deleteExpertAccess(Long expertAccessId);

    List<ExpertAccess> getAllExpertAccess();

    List<User> getAllExperts();

    User excludeExpert(Long userId);

    User putUserIntoExpert (Long userId);

    Recommendation sendRecommendation(Recommendation recommendation);

}
