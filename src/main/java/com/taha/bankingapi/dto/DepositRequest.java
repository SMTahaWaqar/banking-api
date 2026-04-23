package com.taha.bankingapi.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepositRequest {
    @Positive
    private Double amount;
}
