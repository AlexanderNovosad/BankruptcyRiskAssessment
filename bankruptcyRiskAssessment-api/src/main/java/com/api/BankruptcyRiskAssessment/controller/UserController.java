package com.api.BankruptcyRiskAssessment.controller;


import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping(value = "/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        if (isNull(user)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping(value = "/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if (isNull(user)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.userUpdate(user));
    }

    @GetMapping(value = "/user")
    public ResponseEntity<User> getUser(@RequestParam(value = "user_id") Long userId) {
        User user = userService.getUser(userId);
        if (isNull(user)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value = "/user")
    public ResponseEntity<User> deleteUser(@RequestParam(value = "user_id") Long userId) {
        User user = userService.deleteUser(userId);
        if (isNull(user)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/user_list")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userService.getAllUser();
        if (isNull(allUser)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allUser);
    }


}