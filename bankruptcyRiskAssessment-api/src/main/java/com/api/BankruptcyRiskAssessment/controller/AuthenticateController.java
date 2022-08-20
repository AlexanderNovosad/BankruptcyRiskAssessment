package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.service.IAuthService;
import com.api.BankruptcyRiskAssessment.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api")
public class AuthenticateController {
    private static final Logger log = LogManager.getLogger(AuthenticateController.class);
    private final IUserService userService;
    private final IAuthService authService;

    @Autowired
    public AuthenticateController(IUserService userService, IAuthService authService){
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping(value = "/registration")
    public ResponseEntity postRegistration(@RequestBody User user, HttpServletRequest req, HttpServletResponse res, BindingResult result){
        log.info(user);

        if (result.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getFieldErrors());
        } else{
            userService.addUser(user);
            boolean authenticate = authService.login(user.getLogin(), user.getPassword(), req, res);
            if (authenticate){
                User responseUser = loadAuthUser();
                return ResponseEntity.status(HttpStatus.OK).body(responseUser);
            } else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity postLogin(@RequestBody User body, HttpServletRequest request, HttpServletResponse response){
        authService.login(body.getLogin(), body.getPassword(), request, response);

        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal.equals(body.getLogin())){
            return ResponseEntity.status(HttpStatus.OK).body(loadAuthUser());
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping(value = "/logout")
    public ResponseEntity logout(HttpServletRequest req, HttpServletResponse res){
        for (Cookie cookie : req.getCookies()){
            if (cookie.getName().equals("SESSION")){
                cookie.setValue(null);
                cookie.setMaxAge(0);
                res.addCookie(cookie);
            }
        }
        authService.logout(req, res);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(authentication);
        if (authentication != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else{
            return ResponseEntity.status(HttpStatus.OK).body("logout went successfully");
        }
    }

    @RequestMapping(value = "/autologin")
    public ResponseEntity autologin(){
        User responseUser = loadAuthUser();
        if (isNull(responseUser)){
            return ResponseEntity.status(HttpStatus.OK).body(responseUser);
        } else{
            return ResponseEntity.status(HttpStatus.OK).body("{}");
        }
    }


    private User loadAuthUser(){
        Authentication context = SecurityContextHolder.getContext().getAuthentication();

        if (isNull(context)) return null;

        User loadUser = userService.getUserByLogin(context.getName());

        if (!isNull(loadUser)){
            User responseUser = new User();
            responseUser.setFirstName(loadUser.getFirstName());
            responseUser.setEmail(loadUser.getEmail());
            responseUser.setLastName(loadUser.getLastName());
            responseUser.setLogin(loadUser.getLogin());
            responseUser.setUserId(loadUser.getUserId());
            responseUser.setPhone(loadUser.getPhone());
            responseUser.setDepartment(loadUser.getDepartment());
            responseUser.setRole(loadUser.getRole());
            responseUser.setPassword(loadUser.getPassword());
//            responseUser.setConfirm(loadUser.getConfirm());
            return responseUser;
        }
        return null;
    }
}
