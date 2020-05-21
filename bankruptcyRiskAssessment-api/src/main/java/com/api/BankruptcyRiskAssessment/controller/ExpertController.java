package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.ExpertAccess;
import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.service.IExpertService;
import com.api.BankruptcyRiskAssessment.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if (isNull(userService.getUser(userId))) {
            return ResponseEntity.notFound().build();
        }
        User user = userService.getUser(userId);
        return ResponseEntity.ok(expertService.excludeExpert(user));
    }

    @PutMapping(value = "/notUser")
    public ResponseEntity<User> putUserIntoExpert(@RequestBody Long userId){
        if (isNull(userService.getUser(userId))) {
            return ResponseEntity.notFound().build();
        }
        User user = userService.getUser(userId);
        return ResponseEntity.ok(expertService.putUserIntoExpert(user));
    }
}
