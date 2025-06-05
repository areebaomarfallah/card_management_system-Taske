package com.card_management_system.card_management_system.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "card")
public class Card {
    @Id
    private UUID id = UUID.randomUUID();


    @Column(nullable = false)
    private String status; // ACTIVE or INACTIVE

    @Column(nullable = false)
    private LocalDate expiry;

    @Column(nullable = false, unique = true)
    private String cardNumber;
}
