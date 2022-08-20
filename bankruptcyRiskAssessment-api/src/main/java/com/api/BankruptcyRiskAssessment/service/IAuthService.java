package com.api.BankruptcyRiskAssessment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAuthService {

    boolean login(String login, String password, HttpServletRequest req, HttpServletResponse res);

    void logout(HttpServletRequest req, HttpServletResponse res);
}
