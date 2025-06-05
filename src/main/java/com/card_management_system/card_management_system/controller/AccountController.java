package com.card_management_system.card_management_system.controller;

import com.card_management_system.card_management_system.model.Account;
import com.card_management_system.card_management_system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account savedAccount = accountService.createAccount(account);
        return ResponseEntity.status(201).body(savedAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable UUID id, @RequestBody Account account) {
        account.setId(id);
        Account updatedAccount = accountService.updateAccount(account);
        return ResponseEntity.ok(updatedAccount);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable UUID id) {
        Account account = accountService.getAccount(id);
        return ResponseEntity.ok(account);
    }
}
