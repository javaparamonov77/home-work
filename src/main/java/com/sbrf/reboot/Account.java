package com.sbrf.reboot;


import lombok.Getter;

@Getter
public class Account {
    private String accountName;

    public Account(String accountName) {
        this.accountName = accountName;
    }
}
