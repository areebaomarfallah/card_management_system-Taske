package com.card_management_system.card_management_system.service;

import com.card_management_system.card_management_system.EncryptionUtil;
import com.card_management_system.card_management_system.model.Card;
import com.card_management_system.card_management_system.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Card createCard(Card card) {
        card.setStatus("INACTIVE");  // default status when creating a new card

        try {
            card.setCardNumber(EncryptionUtil.encrypt(card.getCardNumber()));
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting card number", e);
        }

        return cardRepository.save(card);
    }


    public Card updateStatus(UUID cardId, String status) {
        Optional<Card> opt = cardRepository.findById(cardId);
        if (opt.isEmpty()) {
            throw new RuntimeException("Card not found");
        }
        Card card = opt.get();
        card.setStatus(status);
        return cardRepository.save(card);
    }

    public Card getCard(UUID id) {
        return cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found"));
    }

    public boolean isCardValid(Card card) {
        return card.getStatus().equals("ACTIVE") && !card.getExpiry().isBefore(LocalDate.now());
    }
}
