package com.sbrf.reboot;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class Account {
    private final BigDecimal amount;
    private final String currency;
    private final LocalDate creationDate;

    public Account(BigDecimal amount, String currency, LocalDate creationDate) {
        this.amount = amount;
        this.currency = currency;
        this.creationDate = creationDate;
    }
}
