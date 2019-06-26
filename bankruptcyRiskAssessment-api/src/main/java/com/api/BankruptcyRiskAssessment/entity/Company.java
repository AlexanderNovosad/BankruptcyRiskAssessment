package com.api.BankruptcyRiskAssessment.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity(name = "Company")
@Table (name = "company")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companyId;

    @Column(nullable = false)
    private String kindOfCompany;

    @Column(nullable = true, unique = true, length = 10)
    private String ipn;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String quadDescription;

    @Column(nullable = false, unique = true, length = 8)
    private String edrpou;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    @Size(min = 6, max = 15)
    private String phone;

    @Column(nullable = true)
    private Boolean confirmation;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="userId", nullable = false)
    private User headOfCompany;

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

    public String getIpn() {
        return ipn;
    }

    public void setIpn(String ipn) {
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

    public String getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(String edrpou) {
        this.edrpou = edrpou;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

    public User getHeadOfCompany() {
        return headOfCompany;
    }

    public void setHeadOfCompany(User headOfCompany) {
        this.headOfCompany = headOfCompany;
    }
}
