package com.taha.bankingapi.controller;

import com.taha.bankingapi.model.BankAccount;
import com.taha.bankingapi.service.BankAccountService;
import com.taha.bankingapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;
    private final TransactionService transactionService;

    public BankAccountController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccountById (@PathVariable("id") Long id) {
        return bankAccountService.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<String> depositAmount (@PathVariable("id") Long id, @RequestParam("amount") Double amount) {
        transactionService.deposit(id, amount);
        return ResponseEntity.ok("Deposit Successful");
    }
}
