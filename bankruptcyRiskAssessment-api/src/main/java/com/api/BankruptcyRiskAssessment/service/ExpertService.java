package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.ExpertAccess;
import com.api.BankruptcyRiskAssessment.entity.Recommendation;
import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.repository.ExpertAccessRepository;
import com.api.BankruptcyRiskAssessment.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class ExpertService implements IExpertService {
    private final IUserService userService;
    private final ExpertAccessRepository expertAccessRepository;
    private final IRoleService roleService;
    private final RecommendationRepository recommendationRepository;

    @Autowired
    public ExpertService(IUserService userService, ExpertAccessRepository expertAccessRepository, IRoleService roleService, RecommendationRepository recommendationRepository){
        this.userService = userService;
        this.expertAccessRepository = expertAccessRepository;
        this.roleService = roleService;
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public List<ExpertAccess> getAccessesByExpert(Long userId) {
        User user = userService.getUser(userId);
        if (isNull(user)) {
            throw new EntityNotFoundException("This user doesn't exist");
        } else if (!user.getRole().getName().equals("Expert")) {
            throw new EntityNotFoundException("This user is not expert");
        }
        return expertAccessRepository.findAllByExpert(user);
    }

    @Override
    public ExpertAccess addExpertAccess(ExpertAccess expertAccess){
        if (isNull(expertAccess)) {
            throw new EntityNotFoundException("This entity is empty");
        }
        return expertAccessRepository.saveAndFlush(expertAccess);
    }

    @Override
    public ExpertAccess getExpertAccess(Long expertAccessId){
        return expertAccessRepository.findById(expertAccessId).orElseThrow(() -> new EntityNotFoundException("Expert access not found"));
    }

    @Override
    public ExpertAccess updateExpertAccess(ExpertAccess expertAccess){
        if (isNull(expertAccess)) {
            throw new EntityNotFoundException("Requested update is empty");
        }
        return expertAccessRepository.save(expertAccess);
    }

    @Override
    public void deleteExpertAccess(Long expertAccessId){
        ExpertAccess expertAccess = this.getExpertAccess(expertAccessId);
        expertAccessRepository.delete(expertAccess);
    }

    @Override
    public List<ExpertAccess> getAllExpertAccess(){
        List<ExpertAccess> allExpertAccesses = expertAccessRepository.findAll();
        if (allExpertAccesses.isEmpty())
            throw new EntityNotFoundException("No expert accesses found in DB");
        return allExpertAccesses;
    }

    @Override
    public List<User> getAllExperts(){
        List<User> users = userService.getUsersByRole(roleService.getRoleByName("Expert"));
        if (users.isEmpty()) {
            throw new EntityNotFoundException("No experts found in DB");
        }
        return users;
    }

    @Override
    public User excludeExpert(Long userId){
        User user = userService.getUser(userId);
        if (isNull(user)) {
            throw new EntityNotFoundException("This user doesn't exist");
        }
        this.deleteAllExpertAccess(expertAccessRepository.findAllByExpert(user));
        user.setRole(roleService.getRoleByName("User"));
        return userService.userUpdate(user);
    }

    private void deleteAllExpertAccess(List<ExpertAccess> expertAccesses){
        if(!expertAccesses.isEmpty())
            expertAccessRepository.deleteAll(expertAccesses);
    }

    @Override
    public User putUserIntoExpert (Long userId){
        User user = userService.getUser(userId);
        if (isNull(user)) {
            throw new EntityNotFoundException("This user doesn't exist");
        }
        user.setRole(roleService.getRoleByName("Expert"));
        return userService.userUpdate(user);
    }

    @Override
    public Recommendation sendRecommendation(Recommendation recommendation){
        if (isNull(recommendation)) {
            throw new EntityNotFoundException("This recommendation is empty");
        }
        recommendation.setDate(new Date(System.currentTimeMillis()));
        return recommendationRepository.saveAndFlush(recommendation);
    }
}
