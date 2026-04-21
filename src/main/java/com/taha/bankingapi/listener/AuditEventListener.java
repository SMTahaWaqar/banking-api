package com.taha.bankingapi.listener;

import com.taha.bankingapi.event.AccountCreditedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuditEventListener {
    @EventListener
    public void handleAccountCredited(AccountCreditedEvent event) {
        System.out.println("Credited: " + event.getBankAccount().getOwner() + " | Amount: " + event.getAmount());
    }
}
