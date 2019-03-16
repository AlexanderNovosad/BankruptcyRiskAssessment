package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {
    User findUserByLogin(String login);
    List<User> findUserByFirstName(String firstName);
    List <User> findUserByLastName(String lastName);
}
