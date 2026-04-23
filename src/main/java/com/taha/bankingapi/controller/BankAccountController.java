package com.taha.bankingapi.controller;

import com.taha.bankingapi.dto.DepositRequest;
import com.taha.bankingapi.model.BankAccount;
import com.taha.bankingapi.service.BankAccountService;
import com.taha.bankingapi.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/accounts")
public class BankAccountController {
    private final BankAccountService bankAccountService;
    private final TransactionService transactionService;

    public BankAccountController(BankAccountService bankAccountService, TransactionService transactionService) {
        this.transactionService = transactionService;
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccountById (@PathVariable("id") Long id) {
        return bankAccountService.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<String> depositAmount (@PathVariable("id") Long id, @RequestBody @Valid DepositRequest request) {
        transactionService.deposit(id, request.getAmount());
        return ResponseEntity.ok("Deposit Successful");
    }
}
