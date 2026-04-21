package com.taha.bankingapi.event;

import com.taha.bankingapi.model.BankAccount;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class AccountCreditedEvent extends ApplicationEvent {
    @Getter private final BankAccount bankAccount;
    @Getter private final Double amount;

    public AccountCreditedEvent(Object source, BankAccount bankAccount, Double amount) {
        super(source);
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

}
