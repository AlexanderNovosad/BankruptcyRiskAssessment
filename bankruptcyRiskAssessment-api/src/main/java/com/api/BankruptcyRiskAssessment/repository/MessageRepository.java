package com.api.BankruptcyRiskAssessment.repository;

import com.api.BankruptcyRiskAssessment.entity.Message;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAll(Sort sort);
    List<Message> findAllByReceiverId(Long user);
}
