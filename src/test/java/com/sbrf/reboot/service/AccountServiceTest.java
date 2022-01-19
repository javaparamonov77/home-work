package com.sbrf.reboot.service;

import com.sbrf.reboot.Account;
import com.sbrf.reboot.AccountRepositoryImpl;
import com.sbrf.reboot.AccountService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AccountServiceTest {

    @Mock
    AccountRepositoryImpl accountRepository;

    AccountService accountService;

    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepositoryImpl.class);

        accountService = new AccountService(accountRepository);
    }

    @SneakyThrows
    @Test
    void bookExist() {
        Account account = new Account("ACC1234NUM");
        Set<Account> accounts = new HashSet();
        accounts.add(account);

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        assertTrue(accountService.isAccountExist(1L, account));
    }

    @SneakyThrows
    @Test
    void bookNotExist() {
        Set<Account> accounts = new HashSet();
        accounts.add(new Account("ACC1234NUM"));

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        assertFalse(accountService.isAccountExist(1L, new Account("ACC456NUM")));
    }

    @SneakyThrows
    @Test
    void getMaxAccountBalance() {
        Account accountWithMaxBalance = Account.builder().clientId(1L).id("4L").balance(new BigDecimal(150000)).build();
        Set<Account> accounts = new HashSet() {{
            add(Account.builder().clientId(1L).id("1L").balance(BigDecimal.TEN).build());
            add(Account.builder().clientId(1L).id("2L").balance(new BigDecimal(200)).build());
            add(Account.builder().clientId(1L).id("3L").balance(new BigDecimal("1.65")).build());
            add(accountWithMaxBalance);
        }};

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        assertEquals(accountWithMaxBalance, accountService.getMaxAccountBalance(1L));
    }


    @SneakyThrows
    @Test
    void getAllAccountsByDateMoreThen() {
        Account account1 = Account.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(2))
                .build();
        Account account2 = Account.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(3))
                .build();
        Account account3 = Account.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(1))
                .build();
        Account account4 = Account.builder().clientId(1L)
                .createDate(LocalDate.now().minusDays(7))
                .build();

        Set<Account> accounts = new HashSet() {{
            add(account1);
            add(account2);
            add(account3);
            add(account4);
        }};

        when(accountRepository.getAllAccountsByClientId(1L)).thenReturn(accounts);

        Set allAccountsByDateMoreThen = accountService.getAllAccountsByDateMoreThen(1L, LocalDate.now().minusDays(2));

        assertEquals(1, allAccountsByDateMoreThen.size());
        assertTrue(allAccountsByDateMoreThen.contains(account3));

    }

    @SneakyThrows
    @Test
    void getAllAccountsWithClientsMore1Id() {
        Account account1 = Account.builder().clientId(3L).id("10L").balance(new BigDecimal(150000)).build();
        Account account2 = Account.builder().clientId(3L).id("12L").balance(new BigDecimal(160000)).build();
        Account account3 = Account.builder().clientId(2L).id("13L").balance(new BigDecimal(170000)).build();
        Account account4 = Account.builder().clientId(1L).id("21L").balance(new BigDecimal(180000)).build();
        Account account5 = Account.builder().clientId(1L).id("22L").balance(new BigDecimal(190000)).build();
        Account account6 = Account.builder().clientId(1L).id("31L").balance(new BigDecimal(200000)).build();


        Set<Account> accounts = new HashSet() {{
            add(account1);
            add(account2);
            add(account3);
            add(account4);
            add(account5);
            add(account6);
        }};


        when(accountRepository.getAllAccounts()).thenReturn(accounts);
        Set<Long> allAccountsWithClientsMore1Id = accountService.getAllAccountsWithClientsMore1Id();


        assertEquals(2, allAccountsWithClientsMore1Id.size());
        assertTrue(allAccountsWithClientsMore1Id.contains(1L));
        assertTrue(allAccountsWithClientsMore1Id.contains(3L));
    }
}