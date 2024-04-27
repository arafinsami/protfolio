package com.hcl.protfolio.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Data
@ToString
@Entity
public class Portfolio {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private String customerId;

    private String customerName;

    private String portfolioNumber;

    private BigDecimal portfolioValue = new BigDecimal("43213");

    private double currentPerformance;

    @Enumerated(EnumType.STRING)
    private InvestmentStrategy investmentStrategy;
}
