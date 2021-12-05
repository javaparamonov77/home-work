package com.sbrf.reboot;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public class Account {
    private Long id;
    private LocalDate createDate;
    private BigDecimal balance;

    public Account(Long id, LocalDate createDate, BigDecimal balance) {
        this.id = id;
        this.createDate = createDate;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}

