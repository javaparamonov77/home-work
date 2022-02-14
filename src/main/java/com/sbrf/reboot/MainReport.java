package com.sbrf.reboot;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class MainReport {

    private BigDecimal totalAmount = new BigDecimal("0");
    private BigDecimal totalAmountReactor = new BigDecimal("0");
    private final List<Account> accountsList = new ArrayList<>();
    private List<Account> accountsListReactor  = new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();
    private final int minAgeFilter = 18;
    private final int maxAgeFilter = 30;
    private final LocalDate minDateFilter = LocalDate.of(2021, 6, 30);
    private final LocalDate maxDateFilter = LocalDate.of(2021, 8, 2);


    public BigDecimal getTotalsWithCompletableFuture(Stream<Customer> customerStream) throws ExecutionException, InterruptedException {

        CompletableFuture<List<Account>> result = getFilteredCustomerList(customerStream)
                .thenCompose(this::getFilteredAccountList);
        bigDecimalSum(result.get());
        return totalAmount;
    }

    public BigDecimal getTotalsWithReact(Stream<Customer> customerStream) {
        Scheduler schedulerMaxProcCore = Schedulers.parallel();
        List<Account> localList = new ArrayList<>();

        Flux<BigDecimal> customerFlux = Flux
                .just(getFilteredCustomers(customerStream))
                .map(a -> {
                    a.forEach(account -> localList.addAll(account.getAccountList()));
                    accountsListReactor = getFilteredAccounts(localList);
                    return bigDecimalSum(accountsListReactor);
                });

        totalAmountReactor = customerFlux.subscribeOn(schedulerMaxProcCore).blockFirst();

        return totalAmountReactor;
    }

    private List<Customer> getFilteredCustomers(Stream<Customer> customerStream) {
        return customerStream
                .filter(customer -> customer.getAge() >= minAgeFilter && customer.getAge() <= maxAgeFilter)
                .collect(Collectors.toList());
    }

    private List<Account> getFilteredAccounts(List<Account> accounts) {
        return accounts.stream()
                .filter(account -> account.getCreationDate().isAfter(minDateFilter)
                && account.getCreationDate().isBefore(maxDateFilter)
                && "RUB".equals(account.getCurrency()))
                .collect(Collectors.toList());
    }


    private CompletableFuture<List<Customer>> getFilteredCustomerList (Stream<Customer> customerStream) {
        return CompletableFuture.supplyAsync(() -> customerList = getFilteredCustomers(customerStream));
    }

    private CompletableFuture<List<Account>> getFilteredAccountList(List<Customer> completableFutureListCustomer) {
        return CompletableFuture.supplyAsync(() -> {
            for (Customer customer : completableFutureListCustomer ) {
                 accountsList.addAll(getFilteredAccounts(customer.getAccountList()));
            }
            return accountsList;
        });
    }

    private BigDecimal bigDecimalSum (List<Account> accountsList){
        for (Account account : accountsList) {
            if(account.getAmount() != null){
                totalAmount = totalAmount.add(account.getAmount());
            }
        }
        return totalAmount;
    }

}
