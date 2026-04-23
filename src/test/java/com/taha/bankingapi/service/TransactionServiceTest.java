package com.taha.bankingapi.service;

import com.taha.bankingapi.exception.AccountNotFoundException;
import com.taha.bankingapi.model.SavingsAccount;
import com.taha.bankingapi.repository.BankAccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    @Mock
    private BankAccountRepository bankAccountRepository;

    @Mock
    private ApplicationEventPublisher applicationEventPublisher;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void depositIncreasesBalance() {
        // Arrange
        SavingsAccount account = new SavingsAccount();
        account.setBalance(1000.0);
        when(bankAccountRepository.findById(1L)).thenReturn(Optional.of(account));

        // Act
        transactionService.deposit(1L, 500.0);

        // Assert
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    void depositOnNonExistentAccountThrowsExceptions() {
        // Arrange
        when(bankAccountRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(AccountNotFoundException.class, () -> transactionService.deposit(99L, 500.0));
    }
}
