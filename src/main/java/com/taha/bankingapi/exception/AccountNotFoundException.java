package com.taha.bankingapi.exception;

import lombok.Getter;

public class AccountNotFoundException extends RuntimeException {
    @Getter
    private final Long id;


    public AccountNotFoundException(Long id) {
        super("Account not found with id: " + id);
        this.id = id;
    }
}
