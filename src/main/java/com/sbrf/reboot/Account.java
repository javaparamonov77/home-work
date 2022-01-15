package com.sbrf.reboot;

import lombok.Data;

@Data
public class Account {

    public String getAccountName() {
        return accountName;
    }

    private String accountName;


    public Account(String accountName) {
        this.accountName = accountName;
    }

    public String getNumber() {
        return accountName;
    }
  
import lombok.Getter;

@Getter
public class Account {
    private String accountName;

    public Account(String accountName) {
        this.accountName = accountName;
    }
}
