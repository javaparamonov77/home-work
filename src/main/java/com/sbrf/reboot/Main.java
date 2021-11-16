package com.sbrf.reboot;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        AccountRepositoryImpl arImpl = new AccountRepositoryImpl();
////        arImpl.getAllAccountsByClientId(1);
//        System.out.println(arImpl.getAllAccountsByClientId(4));
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        AccountService accountService = new AccountService(accountRepository);
//        System.out.println(accountRepository.getAllAccountsByClientId(1l));
//        accountRepository.getAllAccounts().add(new Account("QWERTY"));

        accountService.addNewAccount("QWERTY");
        System.out.println(accountService.isAccountExists(1, new Account("SDASDDASD")));
        accountService.addNewAccount("SDASDDASD");
        System.out.println(accountService.isAccountExists(1, new Account("SDASDDASD")));


    }
}
