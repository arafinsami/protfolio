package com.hcl.protfolio.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TradeType {
    BUY("Buy"),
    SELL("Sell");

    private final String value;

    TradeType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TradeType fromString(String value) {
        for (TradeType tradeType : TradeType.values()) {
            if (tradeType.value.equalsIgnoreCase(value)) {
                return tradeType;
            }
        }
        throw new IllegalArgumentException("Invalid TradeType value: " + value);
    }
}
