package com.sbrf.reboot;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class AccountRepositoryImpl implements AccountRepository {

    public AccountRepositoryImpl(String path) {
        this.path = path;
    }
    /**
     * path - передается в конструкторе класса и используется в методе getAllAccountsByClientId()
     * allAccounts - репозиторий аккаунтов
     */
    private final String path;
    private final Set<Account> allAccounts = new HashSet<>();

    public Set<Account> getAllAccounts() {
        return allAccounts;
    }

    public void setAllAccounts(Account account) {
        this.allAccounts.add(account);
    }

    /**
     * @param clientId - ИД клиента (один клиент может иметь несколько аккаунтов(account))
     * @return Set<Account> - полный набор Set из аккаунтов, принадлежащие конкретному клиенту (clientId)
     * @throws IOException
     */
    @Override
    public Set<Account> getAllAccountsByClientId(long clientId) throws IOException {
        String line;
        long value = 0;
        String account;
        //allAccounts = new HashSet<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            while ((line = br.readLine()) != null) {
                if (line.contains("number") && value == clientId) {
                    account = line.substring(15, line.lastIndexOf("\""));
                    allAccounts.add(new Account(account));
                }
                if (line.contains("clientId")) {
                    value = Integer.parseInt(line.replaceAll("\\D+", ""));
                }
            }
            return allAccounts;
    }
}
