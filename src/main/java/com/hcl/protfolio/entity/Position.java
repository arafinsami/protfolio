package com.hcl.protfolio.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Data
@ToString
@Entity
public class Position {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private String positionId;

    @Enumerated(EnumType.STRING)
    private TradeType tradeType;

    private int units;

    private BigDecimal tradeValue;

    private String transactionRef;

    private String instrument;

    private String portfolio;
}
