package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.ExpertAccess;
import com.api.BankruptcyRiskAssessment.entity.Recommendation;
import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.service.IExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/expert")
public class ExpertController {
    private final IExpertService expertService;

    @Autowired
    public ExpertController(IExpertService expertService){
        this.expertService = expertService;
    }

    @GetMapping(value = "/experts")
    public ResponseEntity<List<User>> getAllExperts(){
        return ResponseEntity.status(HttpStatus.OK).body(expertService.getAllExperts());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ExpertAccess> addExpertAccess(@Valid @RequestBody ExpertAccess expertAccess) {
        return ResponseEntity.status(HttpStatus.CREATED).body(expertService.addExpertAccess(expertAccess));
    }

    @PutMapping(value = "/user")
    public ResponseEntity<User> excludeExpert(@RequestBody Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(expertService.excludeExpert(userId));
    }

    @PutMapping(value = "/notUser")
    public ResponseEntity<User> putUserIntoExpert(@RequestBody Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(expertService.putUserIntoExpert(userId));
    }

    @PostMapping(value = "/recommendation")
    public ResponseEntity<Recommendation> sendRecommendation(@Valid @RequestBody Recommendation recommendation) {
        return ResponseEntity.status(HttpStatus.CREATED).body(expertService.sendRecommendation(recommendation));
    }

    @GetMapping(value = "/expert/companies")
    public ResponseEntity<List<ExpertAccess>> getAccessesByExpert(@RequestParam(value = "userId") Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(expertService.getAccessesByExpert(userId));
    }
}
