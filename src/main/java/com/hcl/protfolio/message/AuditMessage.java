package com.hcl.protfolio.message;

import com.hcl.protfolio.entity.TradeType;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class AuditMessage {
    private String transactionRef;

    private String instrumentId;

    private String instrumentName;

    private TradeType tradeType;

    private Date auditDate;

    private String customerId;
}
