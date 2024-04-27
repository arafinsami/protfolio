package com.hcl.protfolio.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;


@Data
@ToString
@Entity
public class Instrument {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private String instrumentId;

    private String instrumentName;

    private BigDecimal instrumentValue;

    @Enumerated(EnumType.STRING)
    private InstrumentType instrumentType;
}
