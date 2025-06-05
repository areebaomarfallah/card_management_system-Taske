package com.card_management_system.card_management_system.service;

import com.card_management_system.card_management_system.model.Account;
import com.card_management_system.card_management_system.model.Card;
import com.card_management_system.card_management_system.model.Transaction;
import com.card_management_system.card_management_system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CardService cardService;

    @Autowired
    private AccountService accountService;

    public Transaction createTransaction(Transaction transaction) {
        Card card = transaction.getCard();
        Account account = transaction.getAccount();

        // Validate card
        if (!cardService.isCardValid(card)) {
            throw new RuntimeException("Invalid or inactive card");
        }

        // Validate account
        if (!accountService.isAccountActive(account)) {
            throw new RuntimeException("Inactive account");
        }

        // Validate debit balance
        if ("D".equals(transaction.getTransactionType()) &&
                !accountService.hasSufficientBalance(account, transaction.getTransactionAmount())) {
            throw new RuntimeException("Insufficient balance");
        }

        // Update account balance
        if ("D".equals(transaction.getTransactionType())) {
            account.setBalance(account.getBalance().subtract(transaction.getTransactionAmount()));
        } else if ("C".equals(transaction.getTransactionType())) {
            account.setBalance(account.getBalance().add(transaction.getTransactionAmount()));
        }
        accountService.updateAccount(account);

        transaction.setTransactionDate(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }
}
