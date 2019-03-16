package com.api.BankruptcyRiskAssessment.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getKindOfCompany() {
        return kindOfCompany;
    }

    public void setKindOfCompany(String kindOfCompany) {
        this.kindOfCompany = kindOfCompany;
    }

    public Integer getIpn() {
        return ipn;
    }

    public void setIpn(Integer ipn) {
        this.ipn = ipn;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getQuadDescription() {
        return quadDescription;
    }

    public void setQuadDescription(String quadDescription) {
        this.quadDescription = quadDescription;
    }

    public Integer getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(Integer edrpou) {
        this.edrpou = edrpou;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }
}
