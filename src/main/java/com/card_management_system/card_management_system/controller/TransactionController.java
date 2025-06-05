package com.card_management_system.card_management_system.controller;

import com.card_management_system.card_management_system.model.Transaction;
import com.card_management_system.card_management_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.createTransaction(transaction);
        return ResponseEntity.status(201).body(savedTransaction);
    }
}
