package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.ExpertAccess;
import com.api.BankruptcyRiskAssessment.entity.Role;
import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.repository.ExpertAccessRepository;
import com.api.BankruptcyRiskAssessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertService implements IExpertService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExpertAccessRepository expertAccessRepository;
    @Autowired
    private IRoleService roleService;

    @Override
    public List<ExpertAccess> getCompaniesByExpert(Long userId) {
        User user = userRepository.getOne(userId);
        if (user == null) {
            return null;
        }
        List<ExpertAccess> expertAccesses = expertAccessRepository.findAllByExpert(user);
        if (expertAccesses == null) {
            return null;
        }
//        ArrayList<Company> companies = new ArrayList<Company>();
//        expertAccesses.forEach(expertAccess -> companies.add(expertAccess.getCompany()));
        return expertAccesses;
    }

    @Override
    public ExpertAccess addExpertAccess(ExpertAccess expertAccess){
        return expertAccessRepository.saveAndFlush(expertAccess);
    }

    @Override
    public ExpertAccess getExpertAccess(Long expertAccessId){
        ExpertAccess expertAccess = expertAccessRepository.getOne(expertAccessId);
        if (expertAccess == null) {
            return null;
        }

        return expertAccess;

    }

    @Override
    public ExpertAccess updateExpertAccess(ExpertAccess expertAccess){
        return expertAccessRepository.save(expertAccess);
    }

    @Override
    public ExpertAccess deleteExpertAccess(Long expertAccessId){
        ExpertAccess expertAccess = expertAccessRepository.getOne(expertAccessId);
        if (expertAccess == null) {
            return null;
        }
        expertAccessRepository.delete(expertAccess);
        return expertAccess;
    }

    @Override
    public List<ExpertAccess> getAllExpertAccess(){
        return expertAccessRepository.findAll();
    }

    @Override
    public List<User> getAllExperts(){
        Role role = roleService.getRoleByName("Expert");
        return userRepository.findAllByRole(role);
    }

}
