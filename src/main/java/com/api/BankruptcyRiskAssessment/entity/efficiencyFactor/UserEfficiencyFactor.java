package com.api.BankruptcyRiskAssessment.entity.efficiencyFactor;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@Entity(name = "UserEfficiencyFactor")
@Table(name = "userEfficiencyFactor")
@EntityListeners(AuditingEntityListener.class)
public class UserEfficiencyFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long department;

    @Column(nullable = false)
    private Long testCategory;

    @Column(nullable = false)
    private Integer efficiencyFactor;

    @Column(nullable = false)
    private Date date;
}
