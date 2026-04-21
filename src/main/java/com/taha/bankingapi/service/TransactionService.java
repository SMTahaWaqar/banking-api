package com.taha.bankingapi.service;

import com.taha.bankingapi.event.AccountCreditedEvent;
import com.taha.bankingapi.model.BankAccount;
import com.taha.bankingapi.repository.BankAccountRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {
    private final BankAccountRepository bankAccountRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public TransactionService(BankAccountRepository bankAccountRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.bankAccountRepository = bankAccountRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void deposit(Long accountId, Double amount) {
        Optional<BankAccount> account = bankAccountRepository.findById(accountId);
        if (account.isEmpty()) return;
        Double updatedBalance = account.get().getBalance() + amount;
        account.get().setBalance(updatedBalance);
        bankAccountRepository.save(account.get());
        applicationEventPublisher.publishEvent(new AccountCreditedEvent(this, account.get(), amount));
    }
}
