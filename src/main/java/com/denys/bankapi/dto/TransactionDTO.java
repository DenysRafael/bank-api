package com.denys.bankapi.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TransactionDTO {

    @NotNull(message = "Valor é obrigatório")
    @DecimalMin(value = "0.01", message = "Valor mínimo é R$ 0,01")
    private BigDecimal amount;

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}
