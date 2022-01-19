package com.sbrf.reboot;

import java.util.Set;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository{

    public AccountRepositoryImpl(Set<Account> allAccounts) {
        this.allAccounts = allAccounts;
    }

    private Set<Account> allAccounts;

    @Override
    public Set<Account> getAllAccountsByClientId(long clientId) {
        return allAccounts.stream().collect(Collectors.toSet());
    }

    public Set<Account> getAllAccounts() {
        Set<Account> allAccountsExt = allAccounts;
        return allAccountsExt;
    }
}
