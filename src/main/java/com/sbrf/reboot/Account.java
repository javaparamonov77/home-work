package com.sbrf.reboot;

import lombok.Data;

@Data
public class Account {
    String accountName;

    public Account(String accountName) {
        this.accountName = accountName;
    }

    public String getNumber() {
        return accountName;
    }
}
