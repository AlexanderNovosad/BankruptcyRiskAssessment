package com.api.BankruptcyRiskAssessment.controller;


import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
    }

    @PutMapping(value = "/user")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.userUpdate(user));
    }

    @GetMapping(value = "/user")
    public ResponseEntity<User> getUser(@RequestParam(value = "userId") Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(userId));
    }

    @DeleteMapping(value = "/user")
    public ResponseEntity deleteUser(@RequestParam(value = "userId") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body("delete completed successfully");
    }

    @GetMapping(value = "/user_list")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @PostMapping(value = "/expert")
    public ResponseEntity<User> setUserAsExpert(@RequestParam(value = "userId") Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.setUserAsExpert(userId));
    }


}
