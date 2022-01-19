package com.sbrf.reboot;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Setter
@Getter
public class Account {

    public Account(String id) {
        this.id = id;
    }
    private Long clientId;
    private String id;
    private LocalDate createDate;
    private BigDecimal balance;
}
