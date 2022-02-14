package com.sbrf.reboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

class MainReportTest {

    List<Account> accountList1 = new ArrayList<>();
    List<Account> accountList2 = new ArrayList<>();
    List<Account> accountList3 = new ArrayList<>();
    List<Account> accountList4 = new ArrayList<>();
    List<Account> accountList5 = new ArrayList<>();

    List<Customer> customerList;
    MainReport mainReport;

    @BeforeEach
    void setUp() {

        mainReport = new MainReport();

        //Не попадает по клиенту
        accountList1 = new ArrayList<Account>() {{
            add(new Account(new BigDecimal("10000.59"), "RUB", LocalDate.of(2021 , 7, 2)));

        }};
        //Не попадает по всем аккаунтам
        accountList2 = new ArrayList<Account>() {{
            add(new Account(new BigDecimal("20000.239"), "RUB", LocalDate.of(2021 , 6, 30)));
            add(new Account(new BigDecimal("30000.539"), "EUR", LocalDate.of(2021 , 7, 2)));
        }};

        //Не попадает по 1 (валюта),2 (дата), 3 (дата) аккаунтам
        accountList3 = new ArrayList<Account>() {{
            add(new Account(new BigDecimal("50000.52435"), "USD", LocalDate.of(2021 , 7, 30)));
            add(new Account(new BigDecimal("80000.789"), "RUB", LocalDate.of(2021 , 8, 2)));
            add(new Account(new BigDecimal("70000.23"), "RUB", LocalDate.of(2022 , 7, 2)));
            //Попадает
            add(new Account(new BigDecimal("40000.5536"), "RUB", LocalDate.of(2021 , 8, 1)));
            add(new Account(new BigDecimal("60000.52"), "RUB", LocalDate.of(2021 , 7, 1)));

        }};
        accountList4 = new ArrayList<Account>() {{
            add(new Account(new BigDecimal("90000.23"), "RUB", LocalDate.of(2021 , 7, 15)));

        }};

        customerList = new ArrayList<Customer>() {{

            add(new Customer(17, "Петр", accountList1)); ////Не попадает по возрасту (нижняя планка)
            add(new Customer(18, "Аркадий", accountList2));
            add(new Customer(21, "Елена", accountList3));
            add(new Customer(29, "Мария", accountList4));
            add(new Customer(30, "Ольга", accountList5)); //Попадает, но пустая коллекция, поэтому не учитывается
            add(new Customer(31, "Мария", accountList4)); //Не попадает по возрасту (верхняя планка)

        }};

    }

    @Test
    void getTotalsWithCompletableFuture() throws ExecutionException, InterruptedException {
        final double delta = 0.01;
        double factResult = 190_001.3036;
        double actualResult;

        actualResult = mainReport.getTotalsWithCompletableFuture(customerList.stream()).doubleValue();

        Assertions.assertEquals(factResult, actualResult, delta);

    }

    @Test
    void getTotalsWithReact() {
        final double delta = 0.01;
        double factResult = 190_001.3036;
        double actualResult;

        actualResult = mainReport.getTotalsWithReact(customerList.stream()).doubleValue();

        Assertions.assertEquals(factResult, actualResult, delta);
    }
}