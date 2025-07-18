package com.card_management_system.card_management_system.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class AccountRequestDTO {
    private String status;
    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // getters and setters
}

