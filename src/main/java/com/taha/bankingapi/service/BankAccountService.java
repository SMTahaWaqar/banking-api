package com.taha.bankingapi.service;

import com.taha.bankingapi.model.BankAccount;
import com.taha.bankingapi.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public Optional<BankAccount> getAccountById(Long id) {
        return bankAccountRepository.findById(id);
    }
}
