package com.api.BankruptcyRiskAssessment.controller;

import com.api.BankruptcyRiskAssessment.entity.User;
import com.api.BankruptcyRiskAssessment.service.AuthService;
import com.api.BankruptcyRiskAssessment.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class AuthenticateController {
    private static final Logger log = LogManager.getLogger(AuthenticateController.class);


    @Autowired
    private IUserService userService;

    @Autowired
    private AuthService authService;


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity postRegistration(@RequestBody User user, HttpServletRequest req, HttpServletResponse res, BindingResult result) {
        log.info(user);

        if (result.hasErrors()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(result.getFieldErrors());
        } else {
            userService.addUser(user);

            boolean authenticate = authService.login(user.getLogin(), user.getPassword(), req, res);
            if (authenticate) {
                User responseUser = loadAuthUser();

                return ResponseEntity.ok(responseUser);
            } else {

                return ResponseEntity.badRequest().build();
            }

        }
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity postLogin(@RequestBody User body, HttpServletRequest request, HttpServletResponse response) {
        authService.login(body.getLogin(), body.getPassword(), request, response);

        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal.equals(body.getLogin())) {
            return ResponseEntity.ok().body(loadAuthUser());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.POST})
    public ResponseEntity logout(HttpServletRequest req, HttpServletResponse res) {
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("SESSION")) {
                cookie.setValue(null);
                cookie.setMaxAge(0);
                res.addCookie(cookie);
            }
        }
        authService.logout(req, res);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(authentication);
        if (authentication != null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/autologin")
    public ResponseEntity autologin() {
        User responseUser = loadAuthUser();
        if (responseUser != null) {
            return ResponseEntity.ok(responseUser);
        } else {
            return ResponseEntity.ok("{}");
        }
    }


    private User loadAuthUser() {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();

        if (context == null) return null;

        User loadUser = userService.getUserByLogin(context.getName());

        if (loadUser != null) {
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
