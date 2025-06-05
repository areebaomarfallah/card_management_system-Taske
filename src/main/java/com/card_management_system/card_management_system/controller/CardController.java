package com.card_management_system.card_management_system.controller;

import com.card_management_system.card_management_system.model.Card;
import com.card_management_system.card_management_system.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        Card savedCard = cardService.createCard(card);
        return ResponseEntity.status(201).body(savedCard);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Card> updateCardStatus(@PathVariable UUID id, @RequestParam String status) {
        Card updatedCard = cardService.updateStatus(id, status);
        return ResponseEntity.ok(updatedCard);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCard(@PathVariable UUID id) {
        Card card = cardService.getCard(id);
        return ResponseEntity.ok(card);
    }
}
