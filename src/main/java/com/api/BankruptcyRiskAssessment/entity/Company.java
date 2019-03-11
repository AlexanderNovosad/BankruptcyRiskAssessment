package com.api.BankruptcyRiskAssessment.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Company")
@Table (name = "company")
@EntityListeners(AuditingEntityListener.class)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companyId;

    @Column(nullable = false)
    private String kindOfCompany;

    @Column(nullable = true, unique = true, length = 10)
    private Integer ipn;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String quadDescription;

    @Column(nullable = false, unique = true, length = 8)
    private Integer edrpou;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private Integer phone;

    @Column(nullable = true)
    private Boolean confirmation;

}
