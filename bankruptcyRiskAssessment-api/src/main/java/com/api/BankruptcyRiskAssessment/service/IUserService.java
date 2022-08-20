package com.api.BankruptcyRiskAssessment.service;

import com.api.BankruptcyRiskAssessment.entity.Role;
import com.api.BankruptcyRiskAssessment.entity.User;

import java.util.List;

public interface IUserService {

    User addUser(User user);

    User getUser(Long userId);

    User userUpdate(User user);

    void deleteUser(Long userId);

    List<User> getAllUser();

    User getUserByLogin(String login);

    List<User> getUserByFirstName(String firstName);

    List<User> getUserByLastName(String lastName);

    User setUserAsExpert(Long userId);

    List<User> getUsersByRole(Role role);
}
