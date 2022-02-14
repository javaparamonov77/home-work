package com.sbrf.reboot;

import lombok.Getter;

import java.util.List;

@Getter
public class Customer {
    private final int age;
    private final String name;
    private final List<Account> accountList;

    public Customer(int age, String name, List<Account> accountList) {
        this.age = age;
        this.name = name;
        this.accountList = accountList;
    }
}
