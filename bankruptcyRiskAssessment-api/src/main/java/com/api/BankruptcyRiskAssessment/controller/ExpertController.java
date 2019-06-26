package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.ExpertAccess;
import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.service.IExpertService;
import com.api.BankruptcyRiskAssessment.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.isNull;

@RestController("/api/expert")
public class ExpertController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IExpertService expertService;

    @GetMapping
    public ResponseEntity<List<User>> getAllExperts(){
        List<User> users = expertService.getAllExperts();
        if(isNull(users)){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

    @PostMapping(value = "/")
    public ResponseEntity<ExpertAccess> addExpertAccess(@RequestBody ExpertAccess expertAccess) {
        if (isNull(expertAccess)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(expertService.addExpertAccess(expertAccess));
    }
}
