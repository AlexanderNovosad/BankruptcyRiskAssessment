package com.api.BankruptcyRiskAssessment.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthService {
    Logger log = LogManager.getLogger(AuthService.class);

    @Autowired
    private AuthManager authManager;

    @Autowired
    private UserDetailsServiceImpl detailsService;

    @Autowired
    private TokenRememberMeService tokenRememberMeService;


    public boolean login(String login, String password, HttpServletRequest req, HttpServletResponse res) {
        UserDetails userDetails = detailsService.loadUserByUsername(login);

        if (userDetails == null) {
            return false;
        }

        if (!userDetails.getPassword().equals(password)) {
            return false;
        }

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        token.setDetails(userDetails);

        Authentication authenticate = authManager.authenticate(token);

        tokenRememberMeService.login(req, res, authenticate);

        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
            return true;
        } else {
            return false;
        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse res) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        tokenRememberMeService.logout(req, res, authentication);
        SecurityContextHolder.clearContext();
    }

}
