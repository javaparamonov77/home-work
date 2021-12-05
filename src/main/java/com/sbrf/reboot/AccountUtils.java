package com.sbrf.reboot;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AccountUtils {

    public static void sortedById(List<Account> accounts) {
    Collections.sort(accounts, Comparator.comparing(Account::getId));
    }

    public static void sortedByIdDate(List<Account> accounts) {
        Collections.sort(accounts, (o1, o2) -> {
            int result = o1.getId().compareTo(o2.getId());
            if (result == 0) {
                return o1.getCreateDate().compareTo(o2.getCreateDate());
            }
            return result;
        });
    }
    public static void sortedByIdDateBalance(List<Account> accounts) {
        Collections.sort(accounts, (o1, o2) -> {
            int result = o1.getId().compareTo(o2.getId());
            if (result == 0) {
                int result1 = o1.getCreateDate().compareTo(o2.getCreateDate());
                if (result1 == 0) {
                    return o1.getBalance().compareTo(o2.getBalance());

                }
                return result1;
            }
            return result;
        });
    }
}
