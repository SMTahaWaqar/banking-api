package com.taha.bankingapi.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("SAVINGS")
@Data
@NoArgsConstructor
public class SavingsAccount extends BankAccount {
    public Double calculateInterest () {
        return getBalance() * 0.05;
    }
}
