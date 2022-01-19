package com.sbrf.reboot;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AccountService {

    public AccountService(AccountRepositoryImpl accountRepository) {
        this.accountRepository = accountRepository;
    }

    private AccountRepositoryImpl accountRepository;

    public boolean isAccountExist(long l, Account account) {
        boolean result = false;
        for (Account s : this.accountRepository.getAllAccounts()) {
            if (s.getId().equals(account.getId())) {
                result = true;
                break;
            }
        }
        return result;
    }

    public Account getMaxAccountBalance(long clientId) {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        return accounts.stream().max(Comparator.comparing(Account::getBalance)).orElseThrow(NoSuchElementException::new);
    }

     public Set getAllAccountsByDateMoreThen(long clientId, LocalDate minusDays) {
         Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
         return accounts.stream().filter(date -> date.getCreateDate().isAfter(minusDays)).collect(Collectors.toSet());

     }
    /**
     * Доп. задание 5+
     * Вывести список клиентов, у которых имеется более 1 счета
     * @return список уникальных клиентов
     */
    public Set<Long> getAllAccountsWithClientsMore1Id() {
        Set<Account> accounts = accountRepository.getAllAccounts();
        Set<Long> clientsExt = new HashSet();
        Set<Map.Entry<Long, Long>>  accountsSet = accounts.stream().collect(Collectors.groupingBy(Account::getClientId, Collectors.counting())).entrySet();
        for (Map.Entry<Long, Long> clients : accountsSet) {
                if (clients.getValue() > 1 && clients.getKey() != null) {
                    clientsExt.add(clients.getKey());
                }
        }
        return clientsExt;
    }

}
