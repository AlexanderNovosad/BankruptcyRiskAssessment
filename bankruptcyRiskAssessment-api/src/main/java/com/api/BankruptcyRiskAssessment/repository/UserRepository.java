package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository <User, Long> {
    User findUserByLogin(String login);
    List<User> findUserByFirstName(String firstName);
    List <User> findUserByLastName(String lastName);
}
