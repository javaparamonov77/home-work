package com.sbrf.reboot;

public class AccountService {
    AccountRepositoryImpl accountRepository;

    public AccountService(AccountRepositoryImpl accountRepository) {
        this.accountRepository = accountRepository;
    }
    public void addNewAccount(String accountName){
        accountRepository.setAllAccounts(new Account(accountName));
    }

    public boolean isAccountExists(Account account) {
        boolean result = false;
        for (Account s : this.accountRepository.getAllAccounts()) {
            if (s.getAccountName().equals(account.getAccountName())) {
                result = true;
                break;
            }
        }
        return result;
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isAccountExist(Long clientId, Account account) {
        return accountRepository.getAllAccountsByClientId(clientId).contains(account);
    }
}
