package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.ExpertAccess;
import com.api.BankruptcyRiskAssessment.entity.Recommendation;
import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.service.IExpertService;
import com.api.BankruptcyRiskAssessment.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/expert")
public class ExpertController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IExpertService expertService;

    @GetMapping(value = "/experts")
    public ResponseEntity<List<User>> getAllExperts(){
        List<User> users = expertService.getAllExperts();
        return ResponseEntity.ok(users);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ExpertAccess> addExpertAccess(@RequestBody ExpertAccess expertAccess) {
        if (isNull(expertAccess)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(expertService.addExpertAccess(expertAccess));
    }

    @PutMapping(value = "/user")
    public ResponseEntity<User> excludeExpert(@RequestBody Long userId){
        User user = userService.getUser(userId);
        if (isNull(user)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(expertService.excludeExpert(user));
    }

    @PutMapping(value = "/notUser")
    public ResponseEntity<User> putUserIntoExpert(@RequestBody Long userId){
        User user = userService.getUser(userId);
        if (isNull(user)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(expertService.putUserIntoExpert(user));
    }

    @PostMapping(value = "/recommendation")
    public ResponseEntity<Recommendation> sendRecommendation(@RequestBody Recommendation recommendation) {
        if (isNull(recommendation)) {
            return ResponseEntity.notFound().build();
        }
        recommendation.setDate(new Date(System.currentTimeMillis()));
        return ResponseEntity.ok(expertService.sendRecommendation(recommendation));
    }

}
