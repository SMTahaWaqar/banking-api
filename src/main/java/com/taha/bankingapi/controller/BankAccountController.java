package com.taha.bankingapi.controller;

import com.taha.bankingapi.model.BankAccount;
import com.taha.bankingapi.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccountById (@PathVariable("id") Long id) {
        return bankAccountService.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
