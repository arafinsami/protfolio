package com.hcl.protfolio.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Data
@ToString
@Entity
public class Audit {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private String auditId; // Primary Key

    private String transactionRef;

    private Long instrumentId;

    private String instrumentName;

    @Enumerated(EnumType.STRING)
    private TradeType tradeType;

    @Temporal(TemporalType.DATE)
    private Date auditDate;
}
