package com.card_management_system.card_management_system.model;


import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {
    @Id
    private UUID id = UUID.randomUUID();


    @Column(nullable = false)
    private BigDecimal transactionAmount;

    @Column(nullable = false)
    private LocalDateTime transactionDate;

    @Column(nullable = false)
    private String transactionType; // C or D

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
