package com.sbrf.reboot;


public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isAccountExist(Long clientId, Account account) {
        return accountRepository.getAllAccountsByClientId(clientId).contains(account);
    }
}
