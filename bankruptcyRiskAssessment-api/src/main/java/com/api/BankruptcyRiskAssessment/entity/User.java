package com.api.BankruptcyRiskAssessment.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity (name = "User")
@Table (name = "users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(nullable = false)
    @Size(min = 5, max = 20)
    private String firstName;

    @Column(nullable = false)
    @Size(min = 5, max = 20)
    private String lastName;

    @Column(nullable = false)
    @Size(min = 5, max = 20)
    private String login;

    @Column(nullable = false)
    @Size(min = 5, max = 20)
    private String password;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    @Size(min = 6, max = 15)
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "departmentId", nullable = true)
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;

//    @Column(nullable = false)
//    private Boolean confirm;

    public User(User users){
        this.firstName = users.firstName;
        this.lastName = users.lastName;
        this.login = users.login;
        this.password = users.password;
        this.email = users.email;
        this.phone = users.phone;
        this.department = users.department;
        this.role = users.role;
    }

    public User(){}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    public Boolean getConfirm() {
//        return confirm;
//    }
//
//    public void setConfirm(Boolean confirm) {
//        this.confirm = confirm;
//    }


}
