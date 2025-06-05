package com.card_management_system.card_management_system.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@Table(name = "account")
public class Account {
    @Id
    private UUID id = UUID.randomUUID();


    @Column(nullable = false)
    private String status; // ACTIVE or INACTIVE

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;
}
